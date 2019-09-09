package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view;

import android.view.View;

import com.jeka.golub.shelter.domain.walk.Walk;

import java.util.List;

public interface IWalkHistoryView {
    void updateWalkList(List<Walk> walks);

    View getAndroidView();
}
