package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.presenter;

import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.FragmentFabric;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.ShelterFragmentNavigator;

import static com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.NavigationConstants.CHOOSING_SHELTER;
import static com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.NavigationConstants.CREATE_SHELTER_CARD;
import static com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.NavigationConstants.CREATE_VOLUNTEER_CARD;

public class MainMenuPresenter implements IMainMenuPresenter {
    private final ShelterFragmentNavigator navigator;
    private final FragmentFabric fragmentFabric;

    public MainMenuPresenter(ShelterFragmentNavigator navigator, FragmentFabric fragmentFabric) {
        this.navigator = navigator;
        this.fragmentFabric = fragmentFabric;
    }

    @Override
    public void launchToChooseShelterScreen() {
        navigator.setFragment(fragmentFabric.crateByName(CHOOSING_SHELTER));
    }

    @Override
    public void launchToCreateShelterScreen() {
        navigator.setFragment(fragmentFabric.crateByName(CREATE_SHELTER_CARD));
    }

    @Override
    public void launchToCreateVolunteerScreen() {
        navigator.setFragment(fragmentFabric.crateByName(CREATE_VOLUNTEER_CARD));
    }
}
