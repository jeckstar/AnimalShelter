package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.create_animal.CreateAnimalCardFragment;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.AnimalMenuFragment;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter.IShelterCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.IShelterCardView;

import javax.inject.Inject;

import androidx.fragment.app.FragmentTransaction;


public class ShelterCardMenuFragment extends ShelterFragment {

    public static final String KEY_SHELTER_ID = "shelter_id";
    public static final String KEY_ANIMAL_ID = "animal_id";
    @Inject
    IShelterCardPresenter presenter;
    @Inject
    IShelterCardView view;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        long shelterId = bundle.getLong("shelter_id");
        getShelterApplication().dependencyInjection().inject(
                this,
                inflater,
                container,
                savedInstanceState,
                animal -> ShelterCardMenuFragment.this.launchToCreateAnimalMenuScreen(animal.getId(), shelterId),
                shelterId);
        presenter.onCreate();
        view.getAndroidView().findViewById(R.id.btn_home_screen_new_animal).setOnClickListener(v -> launchToCreateAnimalScreen(shelterId));
        return view.getAndroidView();
    }

    private void launchToCreateAnimalMenuScreen(long animalId, long shelterId) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        AnimalMenuFragment animalMenuFragment = AnimalMenuFragment.newInstance(animalId, shelterId);
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, animalMenuFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void launchToCreateAnimalScreen(long shelterId) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        CreateAnimalCardFragment createAnimalCardFragment = CreateAnimalCardFragment.newInstance(shelterId);
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, createAnimalCardFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static ShelterCardMenuFragment newInstance(final long shelterId) {
        Bundle args = new Bundle();
        args.putLong(KEY_SHELTER_ID, shelterId);
        ShelterCardMenuFragment fragment = new ShelterCardMenuFragment();
        fragment.setArguments(args);
        return fragment;
    }

}
