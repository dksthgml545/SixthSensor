package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.DialogPreference;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.AttributeSet;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import kr.ac.kopo.hdyw0w.sixthsensor.item.AddDeviceItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Code;
import kr.ac.kopo.hdyw0w.sixthsensor.retrofit.RetrofitService;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class AddArduinoActivity extends AppCompatActivity {

    private NumberPicker picker;

    private EditText arduinoname;
//    private TextView arduinoid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_arduino);

        final NumberPicker picker = (NumberPicker) findViewById(R.id.daa_number_picker);
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

                        new AlertDialog.Builder(AddArduinoActivity.this).setTitle("저장").setMessage("저장하시겠습니까?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                            public void onClick(DialogInterface dialog, int whichButton) {

                                                Retrofit retrofit = RetrofitService.retrofit;
                                                RetrofitService service = retrofit.create(RetrofitService.class);
                                                final String sensorName = arduinoname.getText().toString();
                                                int pickedValue = picker.getValue();
                                                int measRange = pickedValue;
                                                service.sensor(sensorName,measRange).enqueue(new Callback<AddDeviceItem>() {

                                                    @Override
                                                    public void onResponse(Call<AddDeviceItem> call, Response<AddDeviceItem> response) {

                                                        if (response.isSuccessful()) {
                                                            AddDeviceItem item = response.body();
                                                            assert item != null;

                                                            if (item.getStatus().equals("success")){
                                                                SharedPreferences pref = getSharedPreferences(Code.pref_sensorId, 0);
                                                                SharedPreferences.Editor edit = pref.edit();
                                                                edit.putString(Code.pref_sensorId,item.getSensorId()).apply();

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