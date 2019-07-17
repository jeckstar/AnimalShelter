package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc.ChooseAnimalMenuViewFactory;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter.IAnimalCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.IAnimalCardView;

import javax.inject.Inject;

import androidx.annotation.Nullable;

import static com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment.KEY_ANIMAL_ID;
import static com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment.KEY_SHELTER_ID;


public class AnimalMenuFragment extends ShelterFragment {

    @Inject
    IAnimalCardPresenter presenter;
    @Inject
    ChooseAnimalMenuViewFactory factory;
    private IAnimalCardView view;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = this.getArguments();
            final long animalId = bundle.getLong(KEY_ANIMAL_ID);
            final long shelterId = bundle.getLong(KEY_SHELTER_ID);
            getShelterApplication().dependencyInjection().openAnimalMenuScope(animalId, shelterId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getShelterApplication().dependencyInjection().inject(this);
        view = factory.createView(
                inflater,
                container,
                savedInstanceState,
                volunteer -> presenter.onTakeAnimalForAWalk(volunteer));
        presenter.attachView(view);
        return view.getAndroidView();
    }

    public static AnimalMenuFragment newInstance(long animalId, long shelterId) {
        AnimalMenuFragment animalMenuFragment = new AnimalMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putLong(KEY_ANIMAL_ID, animalId);
        bundle.putLong(KEY_SHELTER_ID, shelterId);
        animalMenuFragment.setArguments(bundle);
        return animalMenuFragment;
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
            getShelterApplication().dependencyInjection().closeAnimalMenuScope();
        }
    }

}



