package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view;

import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
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
                        .inflate(R.layout.item_volunteer, parent, false),
                onChooseListener) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull ShelterViewHolder holder, int position) {
        holder.bind(models.get(position));
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class ShelterViewHolder extends RecyclerView.ViewHolder implements View.OnCreateContextMenuListener{
        private final TextView id;
        private final TextView name;
        private final TextView lastName;
        private final View vCard;
        private String volunteerName;
        private Volunteer currentVolunteer;

        private final IOnItemClickListener<Volunteer> onChooseListener;

        public ShelterViewHolder(@NonNull View itemView, IOnItemClickListener<Volunteer> onChooseListener) {
            super(itemView);
            this.onChooseListener = onChooseListener;

            id = itemView.findViewById(R.id.tv_item_volunteer_id);
            name = itemView.findViewById(R.id.tv_item_volunteer_name);
            lastName = itemView.findViewById(R.id.tv_item_volunteer_last_name);
            vCard = itemView.findViewById(R.id.cl_volunteer_card_volunteer);

            itemView.setOnCreateContextMenuListener(this);
        }

        void bind(Volunteer model) {
            this.currentVolunteer = model;
            volunteerName = String.valueOf(model.getFirstName()) + " " + String.valueOf(model.getLastName());
            id.setText(String.valueOf(model.getId()));
            name.setText(String.valueOf(model.getFirstName()));
            lastName.setText(String.valueOf(model.getLastName()));
        }

        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle(String.format("%s", String.valueOf(volunteerName)));
            menu.add(0, v.getId(), 0, "Walk this animal").setOnMenuItemClickListener(item -> {
                onChooseListener.onClick(currentVolunteer);
                return true;
            });
            menu.add(0, v.getId(), 0, "ЧЁТ ЕЩЕ");
        }

    }
}
