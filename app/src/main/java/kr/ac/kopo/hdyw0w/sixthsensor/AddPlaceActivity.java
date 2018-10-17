package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.item.RegistItem;
import kr.ac.kopo.hdyw0w.sixthsensor.item.UnregistItem;

public class AddPlaceActivity extends AppCompatActivity {

    private RecyclerView registerView;
    private RecyclerView unregisterView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.place_add_activity);

        final EditText placeName = (EditText) findViewById(R.id.gaa_placeName);
        final TextView placeNameConfirm = (TextView) findViewById(R.id.gaa_tvPlaceNameConfirm);
        final EditText raspberryId = (EditText) findViewById(R.id.gaa_raspberryId);

        Button btnLookUp = (Button) findViewById(R.id.gaa_btLookup);
        Button btnSubmit = (Button) findViewById(R.id.gaa_btSubmit);
        final Button btnCancel = (Button) findViewById(R.id.gaa_btCancel);

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
                        new AlertDialog.Builder(AddPlaceActivity.this).setTitle("저장").setMessage("저장하시겠습니까?")
                                .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                                    public void onClick(DialogInterface dialog, int whichButton) {
                                        // 확인시 처리 로직
                                        Toast.makeText(AddPlaceActivity.this, "저장했습니다", Toast.LENGTH_SHORT).show();
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

        ArrayList<UnregistItem> unregistItemArrayList = new ArrayList<>();
        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000001"));
        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000002"));
        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000003"));
        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000004"));
        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000005"));
        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000006"));
        unregistItemArrayList.add(new UnregistItem(R.drawable.ic_trash_can, "ar000007"));

        UnregistAdapter unregistAdapter = new UnregistAdapter(unregistItemArrayList);

        unregisterView.setAdapter(unregistAdapter);

    }
}
