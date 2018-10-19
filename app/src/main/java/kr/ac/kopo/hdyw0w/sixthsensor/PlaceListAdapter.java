package kr.ac.kopo.hdyw0w.sixthsensor;

import android.content.ClipData;
import android.content.Context;
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
import java.util.List;

import kr.ac.kopo.hdyw0w.sixthsensor.item.PlaceListItem;

public class PlaceListAdapter extends RecyclerView.Adapter<PlaceListAdapter.ViewHolder> {
    
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.fil_list, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.binIcon.setImageResource(placeListItemArrayList.get(position).getDrawableId());
        viewHolder.placeName.setText(placeListItemArrayList.get(position).getPlaceName());
        viewHolder.registCount.setText(String.valueOf(placeListItemArrayList.get(position).getRegistCount()));
        viewHolder.fullCount.setText(String.valueOf(placeListItemArrayList.get(position).getFullCount()));
    }

    @Override
    public int getItemCount() {
        return placeListItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private CardView layout;
        private ImageView binIcon;
        private TextView placeName;
        private TextView registCount;
        private TextView fullCount;

        public ViewHolder(View itemView) {
            super(itemView);
            layout = itemView.findViewById(R.id.fl_layout);
            binIcon = itemView.findViewById(R.id.fl_bin_icon);
            placeName = itemView.findViewById(R.id.fl_placeName);
            registCount = itemView.findViewById(R.id.fl_regist_count);
            fullCount = itemView.findViewById(R.id.fl_full_count);

            layout.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    v.getContext().startActivity(new Intent(v.getContext(), ListItemActivity.class));
                }
            });

        }
    }

    private ArrayList<PlaceListItem> placeListItemArrayList;
    PlaceListAdapter(ArrayList<PlaceListItem> placeListItemArrayList){
        this.placeListItemArrayList = placeListItemArrayList;
    }
}
