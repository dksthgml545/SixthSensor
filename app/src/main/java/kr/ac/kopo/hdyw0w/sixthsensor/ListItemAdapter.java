package kr.ac.kopo.hdyw0w.sixthsensor;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import kr.ac.kopo.hdyw0w.sixthsensor.item.DfiListItem;

public class ListItemAdapter extends RecyclerView.Adapter<ListItemAdapter.ViewHolder> {
    @NonNull
    @Override
    public ListItemAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.dfi_list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ListItemAdapter.ViewHolder holder, int position) {
        ViewHolder viewHolder = (ViewHolder) holder;

        viewHolder.binIcon.setImageResource(dfiListItemArrayList.get(position).getDrawableId());
        viewHolder.binName.setText(dfiListItemArrayList.get(position).getItemName());

    }

    @Override
    public int getItemCount() {
        return dfiListItemArrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        private ImageView binIcon;
        private TextView binName;

        public ViewHolder(View itemView) {
            super(itemView);
            binIcon = itemView.findViewById(R.id.dl_ic_trash_can);
            binName = itemView.findViewById(R.id.dl_tv_itemName);
        }
    }

    private ArrayList<DfiListItem> dfiListItemArrayList;

    ListItemAdapter(ArrayList<DfiListItem> dfiListItemArrayList) {
        this.dfiListItemArrayList = dfiListItemArrayList;
    }
}
