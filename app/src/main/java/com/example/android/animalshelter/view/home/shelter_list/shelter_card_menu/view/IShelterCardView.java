package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view;

import android.view.View;

import com.jeka.golub.shelter.domain.animal.Animal;

import java.util.List;

public interface IShelterCardView {

    View getAndroidView();

    void updateAnimalList(List<Animal> newList);
}
