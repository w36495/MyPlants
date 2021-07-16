package com.w36495.myplants;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class PlantAdapter extends RecyclerView.Adapter<PlantAdapter.ViewHolder> implements OnPlantItemClickListener{

    private ArrayList<Plant> plants = new ArrayList<>();
    private OnPlantItemClickListener onPlantItemClickListener;

    @Override
    public void onPlantItemClick(View view, int position) {
        if (onPlantItemClickListener != null) {
            onPlantItemClickListener.onPlantItemClick(view, position);
        }
    }

    public void setOnPlantItemClickListener(OnPlantItemClickListener listener) {
        this.onPlantItemClickListener = listener;
    }

    public Plant getItem(int position) {
        return plants.get(position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        private TextView plantName;
        private TextView plantDate;
        private TextView plantMemo;


        public ViewHolder(@NonNull View itemView, OnPlantItemClickListener listener) {
            super(itemView);

            plantName = (TextView) itemView.findViewById(R.id.rv_plant_show_name);
            plantDate = (TextView) itemView.findViewById(R.id.rv_plant_show_date);
            plantMemo = (TextView) itemView.findViewById(R.id.rv_plant_show_memo);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    // 몇번째 아이템인지 해당 식물의 정보를 반환
                    int position = getAdapterPosition();
                    if (listener != null) {
                        listener.onPlantItemClick(v, position);
                    }
                }
            });

        }

        void bind(Plant plant) {
            plantName.setText(plant.getPlantName());
            plantDate.setText(plant.getPlantDate());
            plantMemo.setText(plant.getPlantMemo());
        }



    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_plant_show, parent, false);
        return new ViewHolder(view, onPlantItemClickListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bind(plants.get(position));


    }


    @Override
    public int getItemCount() {
        return plants.size();
    }

    // 식물 정보 추가
    public void plantAdd(Plant plant) {
        plants.add(plant);
        notifyDataSetChanged();
    }

    // 식물 정보 삭제
    public void plantRemove(int position) {
        plants.remove(position);
        notifyItemRemoved(position);
        notifyDataSetChanged();
    }

    // 식물 정보 수정
    public void plantUpdate(Plant plant, int position) {
        Log.d("수정 : ", "완료");
        plants.set(position, plant);
        notifyItemChanged(position);
        notifyDataSetChanged();
    }



}
