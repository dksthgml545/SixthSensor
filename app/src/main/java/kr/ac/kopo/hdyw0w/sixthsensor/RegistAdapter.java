package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.item.RegistItem;

public class RegistAdapter extends RecyclerView.Adapter<RegistAdapter.ViewHolder> {

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.paa_registerd_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.ivTrashcan.setImageResource(registItemArrayList.get(position).getDrawableId());
        viewHolder.arduinoName.setText((registItemArrayList.get(position).getArduinoName()));
    }

    @Override
    public int getItemCount() {
        return registItemArrayList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivTrashcan;
        private TextView arduinoName;
        private CardView layout;

        public ViewHolder(View itemView) {
            super(itemView);
            ivTrashcan = itemView.findViewById(R.id.prl_ic_trashcan);
            arduinoName = itemView.findViewById(R.id.prl_arduinoName);
            layout = itemView.findViewById(R.id.prl_layout);

//            layout.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    v.getContext().startActivity(new Intent(v.getContext(), ));
//                }
//            });
        }
    }

    private ArrayList<RegistItem> registItemArrayList;
    RegistAdapter(ArrayList<RegistItem> registItemArrayList){
        this.registItemArrayList = registItemArrayList;
    }
}
