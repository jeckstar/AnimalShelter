package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.animal.Animal;

import java.text.SimpleDateFormat;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import static com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView.GENDER_FEMALE;
import static com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView.GENDER_MALE;
import static com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView.GENDER_UNKNOWN;

public class AllAnimalsRecyclerViewAdapter extends RecyclerView.Adapter<AllAnimalsRecyclerViewAdapter.ShelterViewHolder> {
    private final List<Animal> models;
    private final IOnItemClickListener<Animal> onChooseListener;

    public AllAnimalsRecyclerViewAdapter(List<Animal> models, IOnItemClickListener<Animal> onChooseListener) {
        this.models = models;
        this.onChooseListener = onChooseListener;
    }

    @NonNull
    @Override
    public AllAnimalsRecyclerViewAdapter.ShelterViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new AllAnimalsRecyclerViewAdapter.ShelterViewHolder(
                LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_animal, parent, false)) {
        };
    }

    @Override
    public void onBindViewHolder(@NonNull AllAnimalsRecyclerViewAdapter.ShelterViewHolder holder, int position) {
        holder.bind(models.get(position), onChooseListener);
        holder.itemView.startAnimation(AnimationUtils.loadAnimation(holder.itemView.getContext(), android.R.anim.fade_in));
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    static class ShelterViewHolder extends RecyclerView.ViewHolder {
        private final TextView kind;
        private final TextView name;
        private final TextView age;
        private final TextView gender;
        private final TextView period;
        private final TextView lastWalk;
        private final View vCard;

        private SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");


        public ShelterViewHolder(@NonNull View itemView) {
            super(itemView);
            kind = itemView.findViewById(R.id.tv_item_animal_kind);
            name = itemView.findViewById(R.id.tv_item_animal_name);
            age = itemView.findViewById(R.id.tv_item_animal_age);
            gender = itemView.findViewById(R.id.tv_item_animal_sex);
            period = itemView.findViewById(R.id.tv_item_animal_walk_period);
            lastWalk = itemView.findViewById(R.id.tv_item_animal_last_walk);
            vCard = itemView.findViewById(R.id.cl_animal_card_animal);

        }

        void bind(Animal model, IOnItemClickListener<Animal> onChooseListener) {
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
            lastWalk.setText(model.getLastWalkTime() ==
                    Animal.DEFAULT_LAST_WALK_TIME ? vCard.getResources().getString(R.string.animal_has_not_walked) : DATE_FORMAT.format(model.getLastWalkTime()));
            vCard.setOnClickListener(v -> onChooseListener.onClick(model));
        }
    }
}
