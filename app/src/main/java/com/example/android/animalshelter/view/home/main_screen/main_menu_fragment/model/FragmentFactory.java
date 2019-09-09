package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model;

import com.example.android.animalshelter.view.home.create_shelter.CreateShelterCardFragment;
import com.example.android.animalshelter.view.home.create_volunteer.CreateVolunteerCardFragment;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ChoosingShelterFragment;

import androidx.fragment.app.Fragment;

import static com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.NavigationConstants.CHOOSING_SHELTER;
import static com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.NavigationConstants.CREATE_SHELTER_CARD;
import static com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.NavigationConstants.CREATE_VOLUNTEER_CARD;

public class FragmentFactory implements IFragmentFabric {

    @Override
    public Fragment crateByName(String name) {
        Fragment fragment;
        switch (name) {
            case CHOOSING_SHELTER:
                fragment = new ChoosingShelterFragment();
                break;
            case CREATE_SHELTER_CARD:
                fragment = new CreateShelterCardFragment();
                break;
            case CREATE_VOLUNTEER_CARD:
                fragment = new CreateVolunteerCardFragment();
                break;
            default:
                throw new IllegalArgumentException(name);
        }
        return fragment;
    }
}
