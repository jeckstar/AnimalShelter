package com.example.android.animalshelter.view.home.create_shelter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.view.home.create_shelter.presenter.CreateShelterCardPresenter;
import com.example.android.animalshelter.view.home.create_shelter.presenter.ICreateShelterCardPresenter;
import com.example.android.animalshelter.view.home.create_shelter.view.CreateShelterCardView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class CreateShelterCard extends Fragment implements CreateShelterEventConsumer {

    private ICreateShelterCardPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final CreateShelterCardView view = new CreateShelterCardView(inflater, container, savedInstanceState, this);
        presenter = new CreateShelterCardPresenter(
                view,
                ((ShelterApplication) getActivity().getApplication()).getRepositoryFactory().getShelterRepository()
        );
        presenter.onCreate();
        return view.getAndroidView();
    }

    @Override
    public void onSaveClick(String name, String address, String phone) {
        presenter.onSaveCardClicked(name, address, phone);
    }
}
