package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class AllVolunteerRecyclerViewAdapter extends RecyclerView.Adapter<AllVolunteerRecyclerViewAdapter.ShelterViewHolder> {
    private final List<Volunteer> models;
    private final IOnItemClickListener<Volunteer> onChooseListener;

    public AllVolunteerRecyclerViewAdapter(List<Volunteer> models, IOnItemClickListener<Volunteer> onChooseListener) {
        this.models = models;
        this.onChooseListener = onChooseListener;
    }

    @NonNull
    @Override
    public ShelterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ShelterViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_volunteer, parent, false)) {
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
        private final TextView name;
        private final TextView lastName;
        private final View vCard;


        public ShelterViewHolder(@NonNull View itemView) {
            super(itemView);
            id = itemView.findViewById(R.id.tv_item_volunteer_id);
            name = itemView.findViewById(R.id.tv_item_volunteer_name);
            lastName = itemView.findViewById(R.id.tv_item_volunteer_last_name);
            vCard = itemView.findViewById(R.id.cl_volunteer_card_volunteer);
        }

        void bind(Volunteer model, IOnItemClickListener<Volunteer> onChooseListener) {
            id.setText(String.valueOf(model.getId()));
            name.setText(String.valueOf(model.getFirstName()));
            lastName.setText(String.valueOf(model.getLastName()));
            vCard.setOnClickListener(v -> onChooseListener.onClick(model));
        }
    }
}
