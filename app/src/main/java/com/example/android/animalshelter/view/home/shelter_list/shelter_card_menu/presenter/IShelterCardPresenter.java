package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.IShelterCardView;
import com.example.android.animalshelter.view.presenter.Presenter;

public interface IShelterCardPresenter extends Presenter<IShelterCardView> {

    void onShowAllAnimalsForCurrentShelter();
}
