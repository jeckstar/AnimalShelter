package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.FragmentTransaction;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.RouteDisplayFragment;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.ioc.WalkHistoryViewFactory;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.presenter.IWalkHistoryPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view.IWalkHistoryView;

import org.jetbrains.annotations.NotNull;

import javax.inject.Inject;

public class WalkHistoryFragment extends ShelterFragment {

    private static final String ANIMAL_ID = "animal_id";

    @Inject
    IWalkHistoryPresenter presenter;
    @Inject
    WalkHistoryViewFactory factory;
    private IWalkHistoryView view;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = this.getArguments();
            long animalId = bundle.getLong(ANIMAL_ID);
            getShelterApplication().dependencyInjection().openWalkHistoryScope(animalId);
        }
    }

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getShelterApplication().dependencyInjection().inject(this);
        view = factory.createView(inflater,
                container,
                savedInstanceState,
                walk -> launchToRouteDisplayScreen(walk.getId()));
        presenter.attachView(view);
        return view.getAndroidView();
    }

    public void launchToRouteDisplayScreen(long shelterId) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        RouteDisplayFragment createAnimalCardFragment = RouteDisplayFragment.newInstance(shelterId);
        launchToNewScreen(fragmentTransaction, createAnimalCardFragment);
    }

    private void launchToNewScreen(FragmentTransaction fragmentTransaction, ShelterFragment shelterFragment) {
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, shelterFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public static WalkHistoryFragment newInstance(long animalId) {
        WalkHistoryFragment fragment = new WalkHistoryFragment();
        Bundle args = new Bundle();
        args.putLong(ANIMAL_ID, animalId);
        fragment.setArguments(args);
        return fragment;
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
            getShelterApplication().dependencyInjection().closeWalkHistoryScope();
        }
    }

}
