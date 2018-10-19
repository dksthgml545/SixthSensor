package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.item.Code;
import kr.ac.kopo.hdyw0w.sixthsensor.item.DeviceItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.RegistItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Regsensors;
import kr.ac.kopo.hdyw0w.sixthsensor.item.UnregistItem;
import kr.ac.kopo.hdyw0w.sixthsensor.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddPlaceActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    private UnregistItem adapter;

    private RecyclerView registerView;
    private RecyclerView unregisterView;

    private EditText gaa_placeName;
    private EditText gaa_raspberryId;
    private Button gaa_btSubmit;
    private Button gaa_btLookup;

    String deviceId;

    SharedPreferences setting;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_add_activity);

        registerView = findViewById(R.id.gaa_RCV_Registered);
        registerView.setHasFixedSize(true);
        registerView.setLayoutManager(new LinearLayoutManager(this));

        unregisterView = findViewById(R.id.gaa_RCV_Unregistered);
        unregisterView.setHasFixedSize(true);
        unregisterView.setLayoutManager(new LinearLayoutManager(this));

        ArrayList<RegistItem> registItemArrayList = new ArrayList<>();
        registItemArrayList.add(new RegistItem(R.drawable.ic_trash_can, "우리공원 중앙"));

        RegistAdapter registAdapter = new RegistAdapter(registItemArrayList);

        registerView.setAdapter(registAdapter);

        final EditText placeName = (EditText) findViewById(R.id.gaa_placeName);
        final EditText raspberryId = (EditText) findViewById(R.id.gaa_raspberryId);

        Button btnLookUp = (Button) findViewById(R.id.gaa_btLookup);
        Button btnSubmit = (Button) findViewById(R.id.gaa_btSubmit);
        final Button btnCancel = (Button) findViewById(R.id.gaa_btCancel);

//        final String deviceId = raspberryId.getText().toString();

        final RecyclerView raspberryRegister = (RecyclerView) findViewById(R.id.gaa_RCV_Registered);

        setting = getSharedPreferences("setting",0);
        editor = setting.edit();

        raspberryRegister.setLayoutManager(new LinearLayoutManager(this));
        raspberryId.setMovementMethod(new ScrollingMovementMethod());

        Button button_all = (Button) findViewById(R.id.gaa_btLookup);
        button_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v){

//                rArrayList.clear();
//                rAdapter.notifyDataSetChanged();

//                GetData task = new GetData();
//                task.execute("http:://"+"https://iot-sixthsensor.appspot.com/"+"/파일명","");
            }
        });



        btnLookUp.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){

                        deviceId = raspberryId.getText().toString();
                        String token = getSharedPreferences(Code.pref_id, 0).getString(Code.pref_token, "");
                        Retrofit retrofit = RetrofitService.retrofit;
                        RetrofitService service = retrofit.create(RetrofitService.class);
                        service.device(token, deviceId).enqueue(new Callback<DeviceItem>() {

                            @Override
                            public void onResponse(Call<DeviceItem> call, Response<DeviceItem> response) {

                                if (response.isSuccessful()){
                                    DeviceItem item = response.body();
                                    assert item != null;

                                    if (item.getStatus().equals("success")){

                                        ArrayList<UnregistItem> unregistItemArrayList = new ArrayList<>();

                                        ArrayList<Regsensors> unRegDevices = item.getUnregSensors();

                                            for (Regsensors device : unRegDevices ) {
                                                unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, device.getSensorId()));
                                            }

//                                        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000007"));
                                            UnregistAdapter unregistAdapter = new UnregistAdapter(unregistItemArrayList);

                                            unregisterView.setAdapter(unregistAdapter);

                                    } else {
                                        Toast.makeText(AddPlaceActivity.this, "값이 존재하지않습니다! 다시 입력해주세요!", Toast.LENGTH_SHORT).show();
                                    }
                                }  else {
                                    Toast.makeText(AddPlaceActivity.this, "값이 존재하지않습니다. 다시 입력해주세요!!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<DeviceItem> call, Throwable t) {
                                Log.e("onFailure()",t.getMessage(),t);
                                Toast.makeText(AddPlaceActivity.this,t.getMessage(),Toast.LENGTH_SHORT).show();
                            }
                        });
                    }
                }
        );

        btnCancel.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        new AlertDialog.Builder(AddPlaceActivity.this).setTitle("취소").setMessage("취소하시겠습니까?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 확인시 처리 로직
                                        Toast.makeText(AddPlaceActivity.this, "작업을 취소했습니다", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 취소시 처리 로직
                                        Toast.makeText(AddPlaceActivity.this, "취소했습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
                    }
                }
        );

        btnSubmit.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        final String deviceName = placeName.getText().toString();

                        if (deviceName.length() == 0) {
                            Toast.makeText(AddPlaceActivity.this, "장소 이름을 입력해주세요!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        if (deviceName.length() < 2) {
                            Toast.makeText(getApplicationContext(), "장소 이름을 2자리 이상으로 입력해주세요!", Toast.LENGTH_SHORT).show();
                            return;
                        }

                        new AlertDialog.Builder(AddPlaceActivity.this).setTitle("저장").setMessage("저장하시겠습니까?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {

                                        Retrofit retrofit = RetrofitService.retrofit;
                                        RetrofitService service = retrofit.create(RetrofitService.class);
                                        service.place(deviceName).enqueue(new Callback<DeviceItem>() {

                                            @Override
                                            public void onResponse(Call<DeviceItem> call, Response<DeviceItem> response) {

                                                if (response.isSuccessful()){
                                                    try {
                                                        JSONObject object = new JSONObject(response.body().toString());
                                                        if (object.has("status")) {
                                                            String result = object.getString("status");
                                                            if (result.equals("success")) {

//                                                                SharedPreferences preferences = getSharedPreferences(Code.pref_sensorId, 0);
//                                                                SharedPreferences.Editor editor = preferences.edit();
//                                                                editor.putString(Code.pref_sensorId, 0).putString(Code.pref_token, item.getToken()).apply();

                                                                // 확인시 처리 로직
                                                                Toast.makeText(AddPlaceActivity.this, "저장했습니다", Toast.LENGTH_SHORT).show();
                                                                finish();

                                                            }
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<DeviceItem> call, Throwable t) {
                                                Log.e("ERROR",t.getMessage(),t);
                                            }
                                        });
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 취소시 처리 로직
                                        Toast.makeText(AddPlaceActivity.this, "취소했습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
                    }
                }
        );
    }
}