package com.example.android.animalshelter.view.home.shelter_list.view;

import android.view.View;

import com.jeka.golub.shelter.domain.Shelter;

import java.util.List;

public interface IChoosingShelterView {
    View getAndroidView();

    void updateShelterList(List<Shelter> newList);

}
