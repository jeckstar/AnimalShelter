package com.example.android.animalshelter.view.home.shelter_list.choose_shelter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.ChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.IChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.ChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.IChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment;
import com.jeka.golub.shelter.domain.shelter.Shelter;

import java.util.concurrent.Executors;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentTransaction;

public class ChoosingShelterFragment extends ShelterFragment {
    @Inject
    IChoosingShelterPresenter presenter;
    @Inject
    IChoosingShelterView view;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getShelterApplication().dependencyInjection().inject(
                this,
                inflater,
                        container,
                        savedInstanceState,
                shelter -> ChoosingShelterFragment.this.launchToShelterCardScreen(shelter.getId()));
        presenter.onCreate();
        return view.getAndroidView();
    }

    public void launchToShelterCardScreen(long id) {
        ShelterCardMenuFragment shelterCardMenuFragment = ShelterCardMenuFragment.newInstance(id);
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, shelterCardMenuFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}