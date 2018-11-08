package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import kr.ac.kopo.hdyw0w.sixthsensor.item.UnregistItem;

public class AddArduinoActivity extends AppCompatActivity {

    private UnregistItem item;

    private final static String TAG = AddArduinoActivity.class.getSimpleName();

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_add_arduino);

        item = (UnregistItem) getIntent().getSerializableExtra("sensor");
        Log.e(TAG, "item : " + item);
        Log.e(TAG, "id : " + item.getArduinoId());

        final com.shawnlin.numberpicker.NumberPicker picker = (com.shawnlin.numberpicker.NumberPicker) findViewById(R.id.daa_number_picker);
        final EditText arduinoname = (EditText) findViewById(R.id.daa_arduinoName);
        final TextView arduinoId = (TextView) findViewById(R.id.daa_arduinoId);
        arduinoId.setText(item.getArduinoId());

        final Button cancel = (Button) findViewById(R.id.daa_btnCancel);
        final Button submit = (Button) findViewById(R.id.daa_btnSubmit);

        picker.setOnValueChangedListener(new com.shawnlin.numberpicker.NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(com.shawnlin.numberpicker.NumberPicker picker, int oldVal, int newVal) {
                value = newVal;
            }
        });

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

        submit.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

                if (arduinoname.length() == 0) {
                    Toast.makeText(AddArduinoActivity.this, "장치 이름을 입력해주세요!", Toast.LENGTH_SHORT).show();
                    arduinoname.requestFocus();
                    return;
                }

                final String sensorName = arduinoname.getText().toString();
                int pickedValue = picker.getValue();

                item.setArduinoName(sensorName);
                item.setRange(pickedValue);
                Intent intent = new Intent();
                intent.putExtra("sensor", item);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }
}