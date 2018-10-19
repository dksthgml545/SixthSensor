package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.NumberPicker;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.item.AddDeviceItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Code;
import kr.ac.kopo.hdyw0w.sixthsensor.item.DeviceItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.RegistItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Regsensors;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Sensors;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AddArduinoActivity extends AppCompatActivity {

    private NumberPicker picker;

    private EditText arduinoname;
//    private TextView arduinoid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_arduino);

        final com.shawnlin.numberpicker.NumberPicker picker = (com.shawnlin.numberpicker.NumberPicker) findViewById(R.id.daa_number_picker);
        final EditText arduinoname = (EditText) findViewById(R.id.daa_arduinoName);
        final Button cancel = (Button) findViewById(R.id.daa_btnCancel);
        final Button submit = (Button) findViewById(R.id.daa_btnSubmit);

        cancel.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {
                        new AlertDialog.Builder(AddArduinoActivity.this).setTitle("취소").setMessage("취소하시겠습니까?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 확인시 처리 로직
                                        Toast.makeText(AddArduinoActivity.this, "작업을 취소했습니다", Toast.LENGTH_SHORT).show();
                                        finish();
                                    }
                                })
                                .setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 취소시 처리 로직
                                        Toast.makeText(AddArduinoActivity.this, "취소했습니다.", Toast.LENGTH_SHORT).show();
                                    }
                                }).show();
                    }
                }

        );

        submit.setOnClickListener(
                new Button.OnClickListener() {
                    public void onClick(View v) {

                        if (arduinoname.length() == 0) {
                            Toast.makeText(AddArduinoActivity.this, "장치 이름을 입력해주세요!", Toast.LENGTH_SHORT).show();
                            arduinoname.requestFocus();
                            return;
                        }

                        new AlertDialog.Builder(AddArduinoActivity.this).setTitle("저장");
                        new AlertDialog.Builder(AddArduinoActivity.this).setMessage("저장하시겠습니까?");
                        new AlertDialog.Builder(AddArduinoActivity.this).setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {

//                                        Retrofit retrofit = RetrofitService.retrofit;
//                                        RetrofitService service = retrofit.create(RetrofitService.class);
                                        final String sensorName = arduinoname.getText().toString();
//                                        final String deviceName = placename.getText().toString();
                                        String token = getSharedPreferences(Code.pref_id,0).getString(Code.pref_token,"");
                                        int pickedValue = picker.getValue();
                                        int measRange = pickedValue;
                                        service.sensor(token,sensorName, measRange).enqueue(new Callback<AddDeviceItem>() {

                                            @Override
                                            public void onResponse(Call<AddDeviceItem> call, Response<AddDeviceItem> response) {

                                                if (response.isSuccessful()) {
                                                    AddDeviceItem Additem = response.body();
                                                    assert Additem != null;

                                                    if (Additem.getStatus().equals("success")) {
                                                        SharedPreferences pref = getSharedPreferences(Code.pref_sId, 0);
                                                        SharedPreferences.Editor edit = pref.edit();
                                                        edit.putString(Code.pref_sensorId, Additem.getSensorId()).apply();
                                                        edit.putString(Code.pref_sensorName, Additem.getSensorName()).apply();
                                                        edit.putInt(Code.pref_measRange, Additem.getMeasRange()).apply();
                                                        // 저장완료
                                                        edit.commit();



                                                        ArrayList<RegistItem> registItemArrayList = new ArrayList<>();

                                                        ArrayList<Regsensors> regsensors = Additem.getSensors();

                                                    }

                                                    try {
                                                        JSONObject object = new JSONObject(response.body().toString());
                                                        if (object.has("status")) {
                                                            String result = object.getString("status");
                                                            if (result.equals("success")) {

                                                                // 확인시 처리 로직
                                                                Toast.makeText(AddArduinoActivity.this, "저장했습니다", Toast.LENGTH_SHORT).show();
                                                                finish();

                                                            }
                                                        }
                                                    } catch (JSONException e) {
                                                        e.printStackTrace();
                                                    }
                                                }
                                            }

                                            @Override
                                            public void onFailure(Call<AddDeviceItem> call, Throwable t) {
                                                Log.e("ERROR", t.getMessage(), t);
                                            }
                                        });


                                    }
                                }
                        );


                    }
                });
    }
}