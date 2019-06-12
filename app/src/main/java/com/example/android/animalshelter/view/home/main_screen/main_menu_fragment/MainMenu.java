package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.view.home.careate_volunteer.CreateVolunteerCard;
import com.example.android.animalshelter.view.home.create_animal.CreateAnimalCard;
import com.example.android.animalshelter.view.home.create_shelter.CreateShelterCard;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class MainMenu extends Fragment {
    private static final String TAG = MainMenu.class.getSimpleName();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_mein_menu, container, false);
        view.findViewById(R.id.btn_home_screen_new_animal).setOnClickListener(v -> launchToCreateAnimalScreen());
        view.findViewById(R.id.btn_home_screen_new_shelter).setOnClickListener(v -> launchToCreateShelterScreen());
        view.findViewById(R.id.btn_home_screen_new_volunteer).setOnClickListener(v -> launchToCreateVolunteerScreen());
        return view;
    }

    public void launchToCreateAnimalScreen() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new CreateAnimalCard());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void launchToCreateShelterScreen() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new CreateShelterCard());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

    public void launchToCreateVolunteerScreen() {
        final FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, new CreateVolunteerCard());
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }

}
