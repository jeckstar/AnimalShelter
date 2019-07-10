package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import static com.jeka.golub.shelter.persistence.animal.AnimalEntityConverter.DATE_FORMAT;

public class AnimalCardView implements IAnimalCardView {


    private final View rootView;
    private final List<Volunteer> allVolunteers;
    private final AllVolunteerRecyclerViewAdapter allVolunteersAdapter;
    private final RecyclerView rvAllAnimals;

    private final TextView tvKind;
    private final TextView tvName;
    private final TextView tvLastWalkTime;
    private final TextView tvPeriodic;


    public AnimalCardView(@NonNull final LayoutInflater inflater,
                          final ViewGroup container,
                          final Bundle savedInstanceState,
                          IOnItemClickListener<Volunteer> chooseVolunteerListener) {
        rootView = inflater.inflate(R.layout.fragment_animal_card_menu, container, false);

        allVolunteers = new ArrayList<>();
        allVolunteersAdapter = new AllVolunteerRecyclerViewAdapter(
                allVolunteers,
                chooseVolunteerListener);
        rvAllAnimals = rootView.findViewById(R.id.rv_animal_card_screen_volunteers);
        rvAllAnimals.setAdapter(allVolunteersAdapter);
        ;
        rvAllAnimals.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
        tvKind = rootView.findViewById(R.id.tv_animal_menu_animal_kind);
        tvName = rootView.findViewById(R.id.tv_animal_menu_animal_name);
        tvLastWalkTime = rootView.findViewById(R.id.tv_animal_menu_animal_last_walk);
        tvPeriodic = rootView.findViewById(R.id.tv_animal_menu_animal_walk_periodic);
    }

    @Override
    public View getAndroidView() {
        return rootView;
    }

    @Override
    public void updateVolunteerList(List<Volunteer> volunteers) {
        allVolunteers.clear();
        allVolunteers.addAll(volunteers);
        allVolunteersAdapter.notifyDataSetChanged();
    }

    @Override
    public void showSelectedAnimal(String kind, String name, Date lastWalkTime, int walkPeriod) {
        tvKind.setText(kind);
        tvName.setText(name);
        tvLastWalkTime.setText(
                lastWalkTime == Animal.DEFAULT_LAST_WALK_TIME ?
                        rootView.getResources().getString(R.string.animal_has_not_walked) :
                        DATE_FORMAT.format(lastWalkTime));
        tvPeriodic.setText(String.valueOf(walkPeriod));
    }

    @Override
    public void showWarningMassage() {
        Toast
                .makeText(
                        rootView.getContext().getApplicationContext(),
                        "Ups! It is not time to walk yet.",
                        Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showThatVolunteerTakeAnimalForAWalkSuccessfully() {
        Toast
                .makeText(
                        rootView.getContext().getApplicationContext(),
                        "Walking is started",
                        Toast.LENGTH_SHORT)
                .show();
    }
}
