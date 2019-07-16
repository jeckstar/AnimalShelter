package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.presenter.IMainMenuPresenter;

import javax.inject.Inject;

public class MainMenuFragment extends ShelterFragment {
    private static final String TAG = MainMenuFragment.class.getSimpleName();

    @Inject
    IMainMenuPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mein_menu, container, false);
        getShelterApplication().dependencyInjection().inject(this);

        view.findViewById(R.id.btn_home_screen_new_shelter).setOnClickListener(v -> presenter.launchToCreateShelterScreen());
        view.findViewById(R.id.btn_home_screen_new_volunteer).setOnClickListener(v -> presenter.launchToCreateVolunteerScreen());
        view.findViewById(R.id.btn_home_screen_choose_shelter).setOnClickListener(v -> presenter.launchToChooseShelterScreen());
        return view;
    }
}
