package com.example.android.animalshelter.view.home.main_screen.ioc;

import com.example.android.animalshelter.view.home.main_screen.view.IShelterHomeView;
import com.example.android.animalshelter.view.home.main_screen.view.ShelterHomeView;

import javax.inject.Inject;

import androidx.fragment.app.FragmentActivity;

public class HomeScreenViewFactory {

    @Inject
    public HomeScreenViewFactory() {

    }

    public IShelterHomeView createView(FragmentActivity activity) {
        return new ShelterHomeView(activity);
    }

}
