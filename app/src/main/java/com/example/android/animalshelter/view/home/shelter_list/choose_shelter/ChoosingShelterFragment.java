package com.example.android.animalshelter.view.home.shelter_list.choose_shelter;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.ChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.IChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.ChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.IChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment;

import java.util.concurrent.Executors;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ChoosingShelterFragment extends Fragment {

    private IChoosingShelterPresenter presenter;

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for this fragment
        final IChoosingShelterView view =
                new ChoosingShelterView(
                        inflater,
                        container,
                        savedInstanceState,
                        shelter -> ChoosingShelterFragment.this.launchToShelterCardScreen(shelter.getId()));
        presenter = new ChoosingShelterPresenter(
                view,
                ((ShelterApplication) getActivity()
                        .getApplication())
                        .getRepositoryFactory()
                        .getShelterRepository(),
                Executors.newCachedThreadPool());
        presenter.onCreate();
        return view.getAndroidView();
    }

    public void launchToShelterCardScreen(long id) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        ShelterCardMenuFragment shelterCardMenuFragment = new ShelterCardMenuFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("shelter_id", id);
        shelterCardMenuFragment.setArguments(bundle);
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, shelterCardMenuFragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}