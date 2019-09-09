package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.IShelterCardView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.ShelterCardView;
import com.jeka.golub.shelter.domain.animal.Animal;

import javax.inject.Inject;

public class ShelterMenuViewFactory {

    @Inject
    public ShelterMenuViewFactory() {

    }

    public IShelterCardView createView(@NonNull LayoutInflater inflater,
                                       ViewGroup container,
                                       Bundle savedInstanceState,
                                       IOnItemClickListener<Animal> chooseAnimalListener,
                                       IOnItemClickListener<Animal> onShowWalkHistory) {
        return new ShelterCardView(
                inflater,
                container,
                savedInstanceState,
                chooseAnimalListener,
                onShowWalkHistory);
    }

}
