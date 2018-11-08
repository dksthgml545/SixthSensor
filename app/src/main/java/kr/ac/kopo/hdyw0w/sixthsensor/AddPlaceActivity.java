package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
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
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.adapter.RegistAdapter;
import kr.ac.kopo.hdyw0w.sixthsensor.adapter.UnregistAdapter;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Code;
import kr.ac.kopo.hdyw0w.sixthsensor.item.DeviceItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Regsensors;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Sensors;
import kr.ac.kopo.hdyw0w.sixthsensor.item.UnregistItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.UpdateSensors;
import kr.ac.kopo.hdyw0w.sixthsensor.retrofit.RetrofitService;
import okhttp3.ResponseBody;
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

    private ArrayList<UnregistItem> unregistItemArrayList = new ArrayList<>();
    private ArrayList<UnregistItem> registItemArrayList = new ArrayList<>();

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_add_activity);

        registerView = findViewById(R.id.gaa_RCV_Registered);
        registerView.setHasFixedSize(true);
        registerView.setLayoutManager(new LinearLayoutManager(this));
        registerView.setAdapter(new RegistAdapter(registItemArrayList));

        unregisterView = findViewById(R.id.gaa_RCV_Unregistered);
        unregisterView.setHasFixedSize(true);
        unregisterView.setLayoutManager(new LinearLayoutManager(this));

        final EditText placeName = (EditText) findViewById(R.id.gaa_placeName);
        final EditText raspberryId = (EditText) findViewById(R.id.gaa_raspberryId);

        Button btnLookUp = (Button) findViewById(R.id.gaa_btLookup);
        Button btnSubmit = (Button) findViewById(R.id.gaa_btSubmit);
        final Button btnCancel = (Button) findViewById(R.id.gaa_btCancel);

//        final String deviceId = raspberryId.getText().toString();

        final RecyclerView raspberryRegister = (RecyclerView) findViewById(R.id.gaa_RCV_Registered);

        setting = getSharedPreferences("setting", 0);
        editor = setting.edit();

        raspberryRegister.setLayoutManager(new LinearLayoutManager(this));
        raspberryId.setMovementMethod(new ScrollingMovementMethod());

        Button button_all = (Button) findViewById(R.id.gaa_btLookup);
        button_all.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {

//                rArrayList.clear();
//                rAdapter.notifyDataSetChanged();

//                GetData task = new GetData();
//                task.execute("http:://"+"https://iot-sixthsensor.appspot.com/"+"/파일명","");
            }
        });


        btnLookUp.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        // 키보드 숨기기
                        InputMethodManager imm =
                                (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
                        imm.hideSoftInputFromWindow(v.getWindowToken(),0);

                        deviceId = raspberryId.getText().toString();
                        String token = getSharedPreferences(Code.pref_id, 0).getString(Code.pref_token, "");
                        Retrofit retrofit = RetrofitService.retrofit;
                        RetrofitService service = retrofit.create(RetrofitService.class);
                        service.device(token, deviceId).enqueue(new Callback<DeviceItem>() {

                            @Override
                            public void onResponse(Call<DeviceItem> call, Response<DeviceItem> response) {

                                if (response.isSuccessful()) {
                                    DeviceItem item = response.body();
                                    assert item != null;

                                    if (item.getStatus().equals("success")) {
                                        unregistItemArrayList = new ArrayList<>();
                                        registItemArrayList = new ArrayList<>();

                                        if (item.getData().getDevice() != null ) {
                                            ArrayList<Regsensors> regDevices = item.getData().getDevice().getRegSensors();
                                            for (Regsensors device : regDevices) {
                                                UnregistItem unregistItem = new UnregistItem(R.drawable.ic_trash_can_normal, device.getSensorId());
                                                unregistItem.setArduinoName(device.getSensorName());
                                                registItemArrayList.add(unregistItem);
                                            }


                                            ArrayList<Regsensors> unRegDevices = item.getData().getDevice().getUnregSensors();
                                            for (Regsensors device : unRegDevices) {
                                                unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can_normal, device.getSensorId()));
                                            }

//                                        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can_normal, "ar000007"));
                                            registerView.setAdapter(new RegistAdapter(registItemArrayList));
                                            unregisterView.setAdapter(new UnregistAdapter(unregistItemArrayList));
                                        }

                                    } else {
                                        Toast.makeText(AddPlaceActivity.this, "값이 존재하지않습니다! 다시 입력해주세요!", Toast.LENGTH_SHORT).show();
                                    }
                                } else {
                                    Toast.makeText(AddPlaceActivity.this, "값이 존재하지않습니다. 다시 입력해주세요!!", Toast.LENGTH_SHORT).show();
                                }
                            }

                            @Override
                            public void onFailure(Call<DeviceItem> call, Throwable t) {
                                Log.e("onFailure()", t.getMessage(), t);
                                Toast.makeText(AddPlaceActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
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

                                        ArrayList<Sensors> list = new ArrayList<>();
                                        for (int i = 0; i < registItemArrayList.size(); i++) {
                                            Sensors sensors = new Sensors();
                                            UnregistItem item = registItemArrayList.get(i);
                                            sensors.setMeasRange(item.getRange());
                                            sensors.setSensorId(item.getArduinoId());
                                            sensors.setSensorName(item.getArduinoName());

                                            Log.e(TAG, "range : " + sensors.getMeasRange() + " id : " + sensors.getSensorId() + " name : " + sensors.getSensorName());

                                            list.add(sensors);
                                        }

                                        UpdateSensors sensors = new UpdateSensors();
                                        sensors.setDeviceName(placeName.getText().toString());
                                        sensors.setSensors(list);

                                        String token = getSharedPreferences(Code.pref_id, 0).getString(Code.pref_token, "");
                                        Retrofit retrofit = RetrofitService.retrofit;
                                        RetrofitService service = retrofit.create(RetrofitService.class);
                                        service.updateDevice(token, raspberryId.getText().toString(), sensors).enqueue(new Callback<ResponseBody>() {
                                            @Override
                                            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                                                if (response.isSuccessful()) {
                                                    try {
                                                        JSONObject obj = new JSONObject(response.body().string());
                                                        if (obj.has("status")) {
                                                            Toast.makeText(AddPlaceActivity.this, "저장 되었습니다", Toast.LENGTH_SHORT).show();
                                                            finish();
                                                        }
                                                    } catch (JSONException | IOException e) {
                                                        e.printStackTrace();
                                                    }
                                                } else
                                                    Toast.makeText(AddPlaceActivity.this, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
                                            }

                                            @Override
                                            public void onFailure(Call<ResponseBody> call, Throwable t) {
                                                Toast.makeText(AddPlaceActivity.this, "다시 시도해주세요", Toast.LENGTH_SHORT).show();
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

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case Code.REGISTER_REQUEST: {
                    UnregistItem item = (UnregistItem) data.getSerializableExtra("sensor");
                    for (int i = 0; i < unregistItemArrayList.size(); i++) {
                        String id = unregistItemArrayList.get(i).getArduinoId();
                        if (id.equals(item.getArduinoId())) {
                            unregistItemArrayList.remove(i);
                            registItemArrayList.add(item);
                        }
                    }
                    registerView.setAdapter(new RegistAdapter(registItemArrayList));
                    unregisterView.setAdapter(new UnregistAdapter(unregistItemArrayList));
                    break;
                }
            }
        }
    }
}