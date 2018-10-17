package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.Intent;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.item.UnregistItem;

public class UnregistAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private class MyViewHolder extends RecyclerView.ViewHolder {

        private ImageView ivTrashcan;
        private TextView arduinoId;
        private CardView layout;


        MyViewHolder(View view) {
            super(view);
            ivTrashcan = view.findViewById(R.id.pul_ic_trashcan);
            arduinoId = view.findViewById(R.id.pul_arduinoId);
            layout = view.findViewById(R.id.pul_layout);

//            arduinoId.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    Context context= v.getContext();
//                    Intent intent = new Intent();
//                    switch (getAdapterPosition()){
//                        case 0:
//                            intent =  new Intent(context, AddArduinoActivity.class);
//                            context.startActivity(intent);
//                            break;
//                    }
//                }
//            });

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), AddArduinoActivity.class));
                }
            });
        }
    }

    private ArrayList<UnregistItem> unregistItemArrayList;
    UnregistAdapter(ArrayList<UnregistItem> unregistItemArrayList){
        this.unregistItemArrayList = unregistItemArrayList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int ViewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.paa_unregistered_list, parent, false);

        return new MyViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder = (MyViewHolder) holder;

        myViewHolder.ivTrashcan.setImageResource(unregistItemArrayList.get(position).getDrawableId());
        myViewHolder.arduinoId.setText((unregistItemArrayList.get(position).getArduinoId()));
    }

    @Override
    public int getItemCount() {
        return unregistItemArrayList.size();
    }

}
