package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.AnimalCardView;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class ChooseAnimalMenuViewFactory {

    @Inject
    public ChooseAnimalMenuViewFactory() {

    }

    public AnimalCardView createView(@NonNull LayoutInflater inflater,
                                     ViewGroup container,
                                     Bundle savedInstanceState,
                                     IOnItemClickListener<Volunteer> chooseVolunteerListener) {
        return new AnimalCardView(
                inflater,
                container,
                savedInstanceState,
                chooseVolunteerListener);
    }

}
