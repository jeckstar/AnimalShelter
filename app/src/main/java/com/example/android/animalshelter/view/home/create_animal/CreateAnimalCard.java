package com.example.android.animalshelter.view.home.create_animal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.view.home.create_animal.presenter.ICreateAnimalCardPresenter;

import androidx.fragment.app.Fragment;

public class CreateAnimalCard extends Fragment {

    private ICreateAnimalCardPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        return inflater.inflate(R.layout.fragment_create_animal_card, container, false);
    }


}
