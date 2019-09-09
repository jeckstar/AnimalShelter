package com.example.android.animalshelter.view.home.create_animal;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.create_animal.presenter.ICreateAnimalCardPresenter;
import com.example.android.animalshelter.view.home.create_animal.view.ICreateAnimalCardView;

import javax.inject.Inject;

import static com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment.KEY_SHELTER_ID;


public class CreateAnimalCardFragment extends ShelterFragment implements CreateAnimalEventConsumer {

    @Inject
    ICreateAnimalCardPresenter presenter;
    @Inject
    ICreateAnimalCardView view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        Bundle bundle = this.getArguments();
        long shelterId = bundle.getLong("shelter_id");
        getShelterApplication().dependencyInjection().inject(this, inflater, container, savedInstanceState, this, shelterId);
        presenter.onCreate();
        return view.getAndroidView();
    }


    @Override
    public void onSaveClick(String kind, String name, int age, int sex, int walkPeriod) {
        presenter.onSaveCardClicked(kind, name, age, sex, walkPeriod);
    }

    public static CreateAnimalCardFragment newInstance(long shelterId) {
        CreateAnimalCardFragment createAnimalCardFragment = new CreateAnimalCardFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_SHELTER_ID, shelterId);
        createAnimalCardFragment.setArguments(bundle);
        return createAnimalCardFragment;
    }
}
