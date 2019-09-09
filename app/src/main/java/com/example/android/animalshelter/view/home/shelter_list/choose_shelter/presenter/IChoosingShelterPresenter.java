package com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter;

import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.IChoosingShelterView;
import com.example.android.animalshelter.view.presenter.Presenter;

public interface IChoosingShelterPresenter extends Presenter<IChoosingShelterView> {
    void onShowAllShelters();
}

