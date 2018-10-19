package kr.ac.kopo.hdyw0w.sixthsensor;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.item.DfiListItem;

public class ListItemActivity extends AppCompatActivity {

    private RecyclerView binListView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_fil_item);

        final TextView binName = (TextView) findViewById(R.id.dfi_bin_name);

        binListView = findViewById(R.id.dfi_rcv);
        binListView.setHasFixedSize(true);
        binListView.setLayoutManager(new GridLayoutManager(this, 3));

        ArrayList<DfiListItem> dfiListItemArrayList = new ArrayList<>();
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆1"));
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆2"));
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆3"));
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆4"));
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆5"));
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆6"));
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆7"));
        dfiListItemArrayList.add(new DfiListItem(R.drawable.ic_trash_can, "중앙 벤치 옆8"));

        ListItemAdapter listItemAdapter = new ListItemAdapter(dfiListItemArrayList);

        binListView.setAdapter(listItemAdapter);

        findViewById(R.id.dfi_btn_edit).setOnClickListener(
                new Button.OnClickListener(){

                    @Override
                    public void onClick(View v) {

                    }
                }
        );


        findViewById(R.id.dfi_btn_close).setOnClickListener(
                new Button.OnClickListener(){
                    @Override
                    public void onClick(View v) {
                        finish();
                    }
                }
        );

    }
}
