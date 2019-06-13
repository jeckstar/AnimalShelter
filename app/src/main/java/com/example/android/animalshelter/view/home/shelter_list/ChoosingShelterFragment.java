package com.example.android.animalshelter.view.home.shelter_list;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.view.home.create_animal.CreateAnimalCardFragment;
import com.example.android.animalshelter.view.home.shelter_list.presenter.ChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.presenter.IChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.view.ChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.view.IChoosingShelterView;

import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ChoosingShelterFragment extends Fragment implements ChoosingShelterEventConsumer {

    private IChoosingShelterPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final View.OnClickListener chooseShelterListener = v -> launchToCreateAnimalScreen();
        final IChoosingShelterView view = new ChoosingShelterView(inflater, container, savedInstanceState, this, chooseShelterListener);
        presenter = new ChoosingShelterPresenter(
                        view,
                        ((ShelterApplication) getActivity()
                                .getApplication())
                                .getRepositoryFactory()
                                .getShelterRepository(),
                Executors.newCachedThreadPool());
        presenter.onCreate();
//        view.getAndroidView().findViewById(R.id.btn_home_screen_new_animal).setOnClickListener(v -> launchToCreateAnimalScreen());
        return view.getAndroidView();
    }

    public void launchToCreateAnimalScreen() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new CreateAnimalCardFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}