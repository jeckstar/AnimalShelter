package com.example.android.animalshelter.view.home.create_volunteer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.create_volunteer.presenter.CreateVolunteerCardPresenter;
import com.example.android.animalshelter.view.home.create_volunteer.presenter.ICreateVolunteerCardPresenter;
import com.example.android.animalshelter.view.home.create_volunteer.view.CreateVolunteerCardView;

import java.util.concurrent.Executors;

import javax.inject.Inject;

public class CreateVolunteerCardFragment extends ShelterFragment implements CreateVolunteerEventConsumer {

    @Inject
    ICreateVolunteerCardPresenter presenter;
    @Inject
    CreateVolunteerCardView view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getShelterApplication().dependencyInjection()
                .inject(this, inflater, container, savedInstanceState, this);
        presenter.onShowAllVolunteers();
        return view.getAndroidView();
    }

    @Override
    public void onSaveClick(String firstName, String secondName) {
        presenter.onSaveCardClicked(firstName, secondName);
    }
}
