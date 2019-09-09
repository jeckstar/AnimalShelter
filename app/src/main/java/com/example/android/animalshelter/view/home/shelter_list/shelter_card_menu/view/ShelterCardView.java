package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.animal.Animal;

import java.util.ArrayList;
import java.util.List;

public class ShelterCardView implements IShelterCardView {


    private final View rootView;
    private final List<Animal> allAnimals;
    private final AllAnimalsRecyclerViewAdapter allAnimalsAdapter;
    private final RecyclerView rvAllAnimals;


    public ShelterCardView(@NonNull final LayoutInflater inflater,
                           final ViewGroup container,
                           final Bundle savedInstanceState,
                           IOnItemClickListener<Animal> chooseAnimalListener,
                           IOnItemClickListener<Animal> onShowWalkHistory) {
        rootView = inflater.inflate(R.layout.fragment_shelter_card_menu, container, false);

        allAnimals = new ArrayList<>();
        allAnimalsAdapter = new AllAnimalsRecyclerViewAdapter(
                allAnimals,
                chooseAnimalListener,
                onShowWalkHistory);
        rvAllAnimals = rootView.findViewById(R.id.rv_shelter_card_screen_shelters);
        rvAllAnimals.setAdapter(allAnimalsAdapter);
        rvAllAnimals.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }

    @Override
    public View getAndroidView() {
        return rootView;
    }

    @Override
    public void updateAnimalList(List<Animal> animals) {
        allAnimals.clear();
        allAnimals.addAll(animals);
        allAnimalsAdapter.notifyDataSetChanged();
    }
}
