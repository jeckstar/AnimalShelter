package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.view.home.careate_volunteer.CreateVolunteerCardFragment;
import com.example.android.animalshelter.view.home.create_shelter.CreateShelterCardFragment;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ChoosingShelterFragment;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainMenuFragment extends Fragment {
    private static final String TAG = MainMenuFragment.class.getSimpleName();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mein_menu, container, false);
        view.findViewById(R.id.btn_home_screen_new_shelter).setOnClickListener(v -> launchToCreateShelterScreen());
        view.findViewById(R.id.btn_home_screen_new_volunteer).setOnClickListener(v -> launchToCreateVolunteerScreen());
        view.findViewById(R.id.btn_home_screen_choose_shelter).setOnClickListener(v -> launchToChooseShelterScreen());
        return view;
    }

    public void launchToChooseShelterScreen() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new ChoosingShelterFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void launchToCreateShelterScreen() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new CreateShelterCardFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void launchToCreateVolunteerScreen() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new CreateVolunteerCardFragment());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
