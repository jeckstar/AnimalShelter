package com.example.android.animalshelter.view.home.create_shelter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.create_shelter.presenter.CreateShelterCardPresenter;
import com.example.android.animalshelter.view.home.create_shelter.presenter.ICreateShelterCardPresenter;
import com.example.android.animalshelter.view.home.create_shelter.view.CreateShelterCardView;
import com.example.android.animalshelter.view.home.create_shelter.view.ICreateShelterCardView;

import java.util.concurrent.Executors;

import javax.inject.Inject;

import androidx.annotation.NonNull;

public class CreateShelterCardFragment extends ShelterFragment implements CreateShelterEventConsumer {

    @Inject
    ICreateShelterCardPresenter presenter;
    @Inject
    CreateShelterCardView view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getShelterApplication().dependencyInjection().inject(this, inflater, container, savedInstanceState, this);
        return view.getAndroidView();
    }

    @Override
    public void onSaveClick(String name, String address, String phone) {
        presenter.onSaveCardClicked(name, address, phone);
    }
}
