package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.ChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.IShelterCardView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.ShelterCardView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.shelter.Shelter;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class ShelterMenuViewFactory {

    @Inject
    public ShelterMenuViewFactory() {

    }

    public IShelterCardView createView(@NonNull LayoutInflater inflater,
                                       ViewGroup container,
                                       Bundle savedInstanceState,
                                       IOnItemClickListener<Animal> listener) {
        return new ShelterCardView(
                inflater,
                container,
                savedInstanceState,
                listener);
    }

}
