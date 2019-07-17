package com.example.android.animalshelter.view.home.main_screen.presenter;

import com.example.android.animalshelter.view.home.main_screen.view.IShelterHomeView;

public class ShelterHomePresenter implements IShelterHomePresenter {

    private IShelterHomeView view;
    public static int COPIOUI = 0;

    public ShelterHomePresenter() {
        COPIOUI++;
    }

    @Override
    public void attachView(IShelterHomeView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
