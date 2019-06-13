package com.example.android.animalshelter.view.home.create_animal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.view.home.create_animal.presenter.ICreateAnimalCardPresenter;

import androidx.fragment.app.Fragment;

public class CreateAnimalCardFragment extends Fragment {

    private ICreateAnimalCardPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        long myInt = bundle.getLong("shelter_id");


        return inflater.inflate(R.layout.fragment_create_animal_card, container, false);
    }


}
