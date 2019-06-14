package com.example.android.animalshelter.view.home.create_animal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.view.home.create_animal.presenter.CreateAnimalCardPresenter;
import com.example.android.animalshelter.view.home.create_animal.presenter.ICreateAnimalCardPresenter;
import com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView;
import com.example.android.animalshelter.view.home.create_animal.view.ICreateAnimalCardView;

import java.util.concurrent.Executors;

import androidx.fragment.app.Fragment;


public class CreateAnimalCardFragment extends Fragment implements CreateAnimalEventConsumer {

    private ICreateAnimalCardPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        long shelterId = bundle.getLong("shelter_id");
        ICreateAnimalCardView view = new CreateAnimalCardView(
                inflater,
                container,
                savedInstanceState,
                this);
        presenter = new CreateAnimalCardPresenter(
                view,
                ((ShelterApplication) getActivity()
                        .getApplication())
                        .getRepositoryFactory()
                        .getAnimalRepository(),
                Executors.newCachedThreadPool(),
                shelterId);
        presenter.onCreate();


        return view.getAndroidView();
    }


    @Override
    public void onSaveClick(String kind, String name, int age, int sex, int walkPeriod) {
        presenter.onSaveCardClicked(kind, name, age, sex, walkPeriod);
    }
}
