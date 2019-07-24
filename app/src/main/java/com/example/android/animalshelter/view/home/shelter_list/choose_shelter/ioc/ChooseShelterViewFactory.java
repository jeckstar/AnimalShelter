package com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.ChoosingShelterView;
import com.jeka.golub.shelter.domain.shelter.Shelter;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class ChooseShelterViewFactory {

    @Inject
    public ChooseShelterViewFactory() {

    }

    public ChoosingShelterView createView(@NonNull LayoutInflater inflater, ViewGroup container,
                                   Bundle savedInstanceState, IOnItemClickListener<Shelter> listener) {
        return new ChoosingShelterView(inflater, container, savedInstanceState, listener);
    }

}
