package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.adapter.ListItemAdapter;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Code;
import kr.ac.kopo.hdyw0w.sixthsensor.item.DeviceItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.PlaceListItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.Sensors;
import kr.ac.kopo.hdyw0w.sixthsensor.retrofit.RetrofitService;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class ListItemActivity extends AppCompatActivity {

    private RecyclerView binListView;

    private PlaceListItem item;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_fil_item);

        Intent intent = getIntent();

        item = (PlaceListItem) intent.getSerializableExtra("sensors");

        final TextView placeName = (TextView) findViewById(R.id.dfi_place_name);
        placeName.setText(item.getPlaceName());

        binListView = findViewById(R.id.dfi_rcv);
        binListView.setHasFixedSize(true);
        binListView.setLayoutManager(new GridLayoutManager(this, 3));


        findViewById(R.id.dfi_btn_edit).setOnClickListener(
                new Button.OnClickListener() {

                    @Override
                    public void onClick(View v) {
                        Intent intent2 = new Intent(getApplicationContext(), ModifyPlaceActivity.class);
                        startActivity(intent2);
                    }
                }
        );


        findViewById(R.id.dfi_btn_close).setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

        requestNet();

    }

    private void requestNet() {
        Retrofit retrofit = RetrofitService.retrofit;
        RetrofitService service = retrofit.create(RetrofitService.class);
        String token = getApplicationContext().getSharedPreferences(Code.pref_id, 0).getString(Code.pref_token, "");
        service.getSensorList(token, item.getDeviceId()).enqueue(new Callback<DeviceItem>() {
            @Override
            public void onResponse(Call<DeviceItem> call, Response<DeviceItem> response) {
                if (response.isSuccessful()) {
                    DeviceItem item = response.body();
                    ArrayList<Sensors> list = item.getData().getDevice().getSensors();

                    ArrayList<Sensors> sensorsArrayList = new ArrayList<>();

                    for (Sensors sensor : list) {
                        if (sensor.isSensorStatus() == true) {
                            Sensors sensors = new Sensors();
                            sensors.setDrawableId(R.drawable.ic_trash_can_normal);
                            sensors.setSensorName(sensor.getSensorName());
                            sensorsArrayList.add(sensors);
                        }else {
                            Sensors sensors = new Sensors();
                            sensors.setDrawableId(R.drawable.ic_trash_can_err);
                            sensors.setSensorName(sensor.getSensorName());
                            sensorsArrayList.add(sensors);
                        }
                    }
                    binListView.setAdapter(new ListItemAdapter(sensorsArrayList));
                }
            }

            @Override
            public void onFailure(Call<DeviceItem> call, Throwable t) {

            }
        });

    }


}
