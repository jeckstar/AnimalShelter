package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.animal.Animal;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView.GENDER_FEMALE;
import static com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView.GENDER_MALE;
import static com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView.GENDER_UNKNOWN;

public class AllAnimalsRecyclerViewAdapter extends RecyclerView.Adapter<AllAnimalsRecyclerViewAdapter.AnimalViewHolder> {
    private final List<Animal> models;
    private final IOnItemClickListener<Animal> onChooseListener;
    private final IOnItemClickListener<Animal> onShowWalkHistory;

    public AllAnimalsRecyclerViewAdapter(List<Animal> models,
                                         IOnItemClickListener<Animal> onChooseListener,
                                         IOnItemClickListener<Animal> onShowWalkHistory) {
        this.models = models;
        this.onChooseListener = onChooseListener;
        this.onShowWalkHistory = onShowWalkHistory;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AnimalViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_animal, parent, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        holder.bind(models.get(position), onChooseListener, onShowWalkHistory);
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class AnimalViewHolder extends RecyclerView.ViewHolder {
        private final TextView kind;
        private final TextView name;
        private final TextView age;
        private final TextView gender;
        private final TextView period;
        private final TextView lastWalk;
        private final View vCard;
        private final Button btnWalkHistory;
        private final int walkingBackground;
        private final int unlockedBackground;
        private final int restBackground;

        private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd 'at' HH:mm:ss");


        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            kind = itemView.findViewById(R.id.tv_item_walk_kind);
            name = itemView.findViewById(R.id.tv_item_walk_name);
            age = itemView.findViewById(R.id.tv_item_walk_volunteer_first_name);
            gender = itemView.findViewById(R.id.tv_item_walk_volunteer_last_name);
            period = itemView.findViewById(R.id.tv_item_animal_walk_period);
            lastWalk = itemView.findViewById(R.id.tv_item_animal_last_walk);
            vCard = itemView.findViewById(R.id.cl_animal_card_animal);
            btnWalkHistory = itemView.findViewById(R.id.btn_item_animal_walk_history);
            walkingBackground = vCard.getResources().getColor(R.color.redDE);
            unlockedBackground = vCard.getResources().getColor(R.color.green00B);
            restBackground = vCard.getResources().getColor(R.color.chocolate);
        }

        void bind(Animal model,
                  IOnItemClickListener<Animal> onChooseListener,
                  IOnItemClickListener<Animal> onShowWalkHistory) {
            kind.setText(model.getKind());
            name.setText(model.getName());
            age.setText(String.format("%s year(s)", String.valueOf(model.getAge())));
            switch (model.getSex()) {
                case (GENDER_FEMALE):
                    gender.setText(vCard.getResources().getString(R.string.gender_female));
                    break;
                case (GENDER_MALE):
                    gender.setText(vCard.getResources().getString(R.string.gender_male));
                    break;
                case (GENDER_UNKNOWN):
                    gender.setText(vCard.getResources().getString(R.string.gender_unknown));
                    break;
            }
            period.setText(String.format("%shr", String.valueOf(model.getWalkPeriod())));
            // ready to walk
            if (model.getLastWalkTime() == Animal.DEFAULT_LAST_WALK_TIME ||
                    (model.getLastWalkTime().getTime()
                            + hourToMillisecond(model.getWalkPeriod())
                            + hourToMillisecond(model.getWalkPeriod())) < (new Date().getTime())) {
                vCard.setBackgroundColor(unlockedBackground);
                lastWalk.setText(model.getLastWalkTime() ==
                        Animal.DEFAULT_LAST_WALK_TIME ? vCard.getResources().getString(R.string.animal_has_not_walked) : DATE_FORMAT.format(model.getLastWalkTime()));
                vCard.setOnClickListener(v -> onChooseListener.onClick(model));
            }
            // locked to walk - walking now
            else if ((model.getLastWalkTime().getTime() + hourToMillisecond(model.getWalkPeriod())) > new Date().getTime()) {
                vCard.setBackgroundColor(walkingBackground);
                lastWalk.setText(lockedMassage(model));
            }
            // walked not so long ago
            else if ((model.getLastWalkTime().getTime() + hourToMillisecond(model.getWalkPeriod())) < new Date().getTime()
                    && new Date().getTime() < (new Date().getTime()) + hourToMillisecond(model.getWalkPeriod())) {
                vCard.setBackgroundColor(restBackground);
                lastWalk.setText(restMassage(model));
            }
            btnWalkHistory.setOnClickListener(v -> onShowWalkHistory.onClick(model));
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
