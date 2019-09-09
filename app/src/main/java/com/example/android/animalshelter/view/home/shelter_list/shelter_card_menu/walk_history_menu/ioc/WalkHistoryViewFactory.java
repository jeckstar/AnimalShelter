package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view.IWalkHistoryView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view.WalkHistoryView;
import com.jeka.golub.shelter.domain.walk.Walk;

import javax.inject.Inject;

public class WalkHistoryViewFactory {

    @Inject
    public WalkHistoryViewFactory() {

    }

    public IWalkHistoryView createView(@NonNull LayoutInflater inflater,
                                       ViewGroup container,
                                       Bundle savedInstanceState,
                                       IOnItemClickListener<Walk> chooseWalkListener) {
        return new WalkHistoryView(inflater,
                container,
                savedInstanceState,
                chooseWalkListener
        );
    }
}
