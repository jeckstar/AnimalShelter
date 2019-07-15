package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter.AnimalCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter.IAnimalCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.AnimalCardView;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.IAnimalCardView;

import java.util.concurrent.Executors;

import androidx.fragment.app.Fragment;

import static com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment.KEY_ANIMAL_ID;
import static com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment.KEY_SHELTER_ID;


public class AnimalMenuFragment extends Fragment {

    private IAnimalCardPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        final long animalId = bundle.getLong(KEY_ANIMAL_ID);
        final long shelterId = bundle.getLong(KEY_SHELTER_ID);
        final IAnimalCardView view =
                new AnimalCardView(
                        inflater,
                        container,
                        savedInstanceState,
                        volunteer -> {
                            presenter.onTakeAnimalForAWalk(volunteer);
                        });
        presenter = new AnimalCardPresenter(
                view,
                ((ShelterApplication) getActivity()
                        .getApplication())
                        .getRepositoryFactory()
                        .getVolunteerRepository(),
                ((ShelterApplication) getActivity()
                        .getApplication())
                        .getRepositoryFactory()
                        .getAnimalRepository(),
                ((ShelterApplication) getActivity()
                        .getApplication())
                        .getRepositoryFactory()
                        .getWalkRepository(),
                Executors.newCachedThreadPool(),
                animalId,
                shelterId);
        presenter.onCreate();

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

}



