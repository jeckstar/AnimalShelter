package com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.ioc;

import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.MainMenuFragment;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.FragmentFabric;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.model.ShelterFragmentNavigator;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.presenter.IMainMenuPresenter;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.presenter.MainMenuPresenter;

import dagger.Module;
import dagger.Provides;

@Module
public class MainMenuModule {
    private final ShelterFragmentNavigator navigator;
    private final FragmentFabric fragmentFabric;

    public MainMenuModule(MainMenuFragment fragment) {
        this.navigator = new ShelterFragmentNavigator(fragment);
        this.fragmentFabric = new FragmentFabric();
    }

    @Provides
    public ShelterFragmentNavigator getNavigator() {
        return navigator;
    }

    @Provides
    public FragmentFabric getFragmentFabric() {
        return fragmentFabric;
    }

    @Provides
    public IMainMenuPresenter getMainMenuPresenter(ShelterFragmentNavigator navigator,
                                                   FragmentFabric fragmentFabric) {
        return new MainMenuPresenter(
                navigator,
                fragmentFabric
        );
    }
}
