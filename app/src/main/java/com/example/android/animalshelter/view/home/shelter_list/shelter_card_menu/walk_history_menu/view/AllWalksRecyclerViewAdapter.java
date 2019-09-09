package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.walk.Walk;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class AllWalksRecyclerViewAdapter extends RecyclerView.Adapter<AllWalksRecyclerViewAdapter.WalkViewHolder> {
    private final List<Walk> models;
    private final IOnItemClickListener<Walk> onChooseListener;

    public AllWalksRecyclerViewAdapter(List<Walk> models, IOnItemClickListener<Walk> onChooseListener) {
        this.models = models;
        this.onChooseListener = onChooseListener;
    }

    @NonNull
    @Override
    public WalkViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new WalkViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_walk, parent, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull WalkViewHolder holder, int position) {
        holder.bind(models.get(position), onChooseListener);
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class WalkViewHolder extends RecyclerView.ViewHolder {

        private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");
        private final TextView animalKind;
        private final TextView animalName;
        private final TextView volunteerFirstName;
        private final TextView volunteerLastName;
        private final TextView lastWalk;
        private final Button btnShowRoute;

        public WalkViewHolder(@NonNull View itemView) {
            super(itemView);
            animalKind = itemView.findViewById(R.id.tv_item_walk_kind);
            animalName = itemView.findViewById(R.id.tv_item_walk_name);
            volunteerFirstName = itemView.findViewById(R.id.tv_item_walk_volunteer_first_name);
            volunteerLastName = itemView.findViewById(R.id.tv_item_walk_volunteer_last_name);
            lastWalk = itemView.findViewById(R.id.tv_item_walk_last_walk);
            btnShowRoute = itemView.findViewById(R.id.btn_item_walk_show_route);
        }

        void bind(Walk model,
                  IOnItemClickListener<Walk> onChooseListener) {
            Animal currentAnimal = model.getAnimal();
            animalKind.setText(currentAnimal.getKind());
            animalName.setText(currentAnimal.getName());
            Volunteer currentVolunteer = model.getVolunteer();
            volunteerFirstName.setText(currentVolunteer.getFirstName());
            volunteerLastName.setText(currentVolunteer.getLastName());
            lastWalk.setText(String.format("Start at %s", DATE_FORMAT.format(model.getWalkTime())));
            btnShowRoute.setOnClickListener(v -> onChooseListener.onClick(model));

        }

        private String lockedMassage(Animal model) {
            return String.format("%s is walking now. Walk will end %s.",
                    model.getName(),
                    String.valueOf(
                            DATE_FORMAT.format(
                                    new Date(
                                            model.getLastWalkTime().getTime() + hourToMillisecond(model.getWalkPeriod())
                                    )
                            )
                    )
            );
        }

        private String restMassage(Animal model) {
            return String.format("%s walked not so long ago. Walk will unlocked %s.",
                    model.getName(),
                    String.valueOf(
                            DATE_FORMAT.format(
                                    new Date(
                                            model.getLastWalkTime().getTime()
                                                    + hourToMillisecond(model.getWalkPeriod())
                                                    + hourToMillisecond(model.getWalkPeriod()
                                            )
                                    )
                            )
                    )
            );
        }

        private long hourToMillisecond(int walkPeriod) {
            return walkPeriod * 60 * 60 * 1000;
        }
    }
}
