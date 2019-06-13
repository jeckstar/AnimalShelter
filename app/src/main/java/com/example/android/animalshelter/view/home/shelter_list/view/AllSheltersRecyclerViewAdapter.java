package com.example.android.animalshelter.view.home.shelter_list.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.Shelter;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

class AllSheltersRecyclerViewAdapter extends RecyclerView.Adapter<AllSheltersRecyclerViewAdapter.ShelterViewHolder> {
    private final List<Shelter> models;
    private final IOnItemClickListener<Shelter> onChooseListener;

    public AllSheltersRecyclerViewAdapter(List<Shelter> models, IOnItemClickListener<Shelter> onChooseListener) {
        this.models = models;
        this.onChooseListener = onChooseListener;
    }

    @NonNull
    @Override
    public ShelterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShelterViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_shelter, parent, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ShelterViewHolder holder, int position) {
        holder.bind(models.get(position), onChooseListener);
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in));
    }

    @Override
    public int getItemCount() {
       return models.size();
    }

    static class ShelterViewHolder extends RecyclerView.ViewHolder {
        private final TextView id;
        private final TextView title;
        private final TextView address;
        private final TextView phone;
        private final View vCard;


        public ShelterViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_item_shelter_id);
            title = itemView.findViewById(R.id.tv_item_shelter_title);
            address = itemView.findViewById(R.id.tv_item_shelter_address);
            phone = itemView.findViewById(R.id.tv_item_shelter_phone);
            vCard = itemView;
        }

        void bind(Shelter model, IOnItemClickListener<Shelter> onChooseListener) {
            id.setText(String.valueOf(model.getId()));
            title.setText(model.getAddress());
            address.setText(model.getAddress());
            phone.setText(model.getPhoneNumber());
            vCard.setOnClickListener(v -> onChooseListener.onClick(model));
        }
    }
}
