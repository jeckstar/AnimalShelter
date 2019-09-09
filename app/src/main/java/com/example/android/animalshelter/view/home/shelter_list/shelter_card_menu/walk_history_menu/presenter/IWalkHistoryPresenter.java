package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.presenter;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view.IWalkHistoryView;
import com.example.android.animalshelter.view.presenter.Presenter;

public interface IWalkHistoryPresenter extends Presenter<IWalkHistoryView> {
    void onShowWalkHistory();
}
