package com.example.android.animalshelter.view.home.shelter_list.choose_shelter;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc.ChooseShelterViewFactory;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.IChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.ChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentTransaction;

public class ChoosingShelterFragment extends ShelterFragment {
    @Inject
    IChoosingShelterPresenter presenter;
    @Inject
    ChooseShelterViewFactory viewFactory;
    private ChoosingShelterView view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Log.d("TestLog", "Opening scope");
            getShelterApplication().dependencyInjection().openChooseShelterScope();
        }
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getShelterApplication().dependencyInjection().inject(this);
        this.view = viewFactory.createView(
                inflater,
                container,
                savedInstanceState,
                shelter -> ChoosingShelterFragment.this.launchToShelterCardScreen(shelter.getId()));
        presenter.attachView(this.view);
        Log.d("TestLog", "onCreateView: " + presenter);
        return view.getAndroidView();
    }

    public void launchToShelterCardScreen(long id) {
        ShelterCardMenuFragment shelterCardMenuFragment = ShelterCardMenuFragment.newInstance(id);
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, shelterCardMenuFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.presenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getActivity().isFinishing()) {
            getShelterApplication().dependencyInjection().closeChooseShelterScope();
        }
    }
}