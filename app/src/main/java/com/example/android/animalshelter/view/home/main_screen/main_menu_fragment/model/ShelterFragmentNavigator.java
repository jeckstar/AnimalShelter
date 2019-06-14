package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model;

import com.example.android.animalshelter.R;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

public class ShelterFragmentNavigator implements IShelterFragmentNavigator {
    private final Fragment rootFragment;

    public ShelterFragmentNavigator(Fragment rootFragment) {
        this.rootFragment = rootFragment;
    }

    @Override
    public void setFragment(Fragment fragment) {
        final FragmentTransaction fragmentTransaction = rootFragment.getFragmentManager().beginTransaction();
        fragmentTransaction.replace(R.id.fl_home_screen_fragment_layout, fragment);
        fragmentTransaction.addToBackStack(null);
        fragmentTransaction.commit();
    }
}
