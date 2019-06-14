package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.view.home.create_animal.CreateAnimalCardFragment;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter.IShelterCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter.ShelterCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.IShelterCardView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.ShelterCardView;

import java.util.concurrent.Executors;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;


public class ShelterCardMenuFragment extends Fragment {

    public static final String KEY_SHELTER_ID = "shelter_id";
    private IShelterCardPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Bundle bundle = this.getArguments();
        long shelterId = bundle.getLong("shelter_id");
        final IShelterCardView view =
                new ShelterCardView(
                        inflater,
                        container,
                        savedInstanceState,
                        animal -> {
//                                ShelterCardMenuFragment.this.launchToCreateAnimalScreen(shelterId);
                        });
        presenter = new ShelterCardPresenter(
                view,
                ((ShelterApplication) getActivity()
                        .getApplication())
                        .getRepositoryFactory()
                        .getAnimalRepository(),
                Executors.newCachedThreadPool(),
                shelterId);
        presenter.onCreate();
        view.getAndroidView().findViewById(R.id.btn_home_screen_new_animal).setOnClickListener(v -> launchToCreateAnimalScreen(shelterId));
        return view.getAndroidView();
    }

    public void launchToCreateAnimalScreen(long id) {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        CreateAnimalCardFragment createAnimalCardFragment = new CreateAnimalCardFragment();
        Bundle bundle = new Bundle();
        bundle.putLong("shelter_id", id);
        createAnimalCardFragment.setArguments(bundle);
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
