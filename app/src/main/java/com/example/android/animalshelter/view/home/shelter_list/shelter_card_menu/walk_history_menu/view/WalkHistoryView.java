package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.walk.Walk;

import java.util.ArrayList;
import java.util.List;

public class WalkHistoryView implements IWalkHistoryView {

    private final View rootView;
    private final List<Walk> allWalks;
    private final AllWalksRecyclerViewAdapter allWalksAdapter;
    private final RecyclerView rvAllWalks;

    public WalkHistoryView(LayoutInflater inflater,
                           ViewGroup container,
                           Bundle savedInstanceState,
                           IOnItemClickListener<Walk> chooseWalkListener) {

        rootView = inflater.inflate(R.layout.fragment_walk_history, container, false);

        allWalks = new ArrayList<>();
        allWalksAdapter = new AllWalksRecyclerViewAdapter(
                allWalks,
                chooseWalkListener);
        rvAllWalks = rootView.findViewById(R.id.rv_walk_history);
        rvAllWalks.setAdapter(allWalksAdapter);
        rvAllWalks.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }

    @Override
    public void updateWalkList(List<Walk> walks) {
        allWalks.clear();
        allWalks.addAll(walks);
        allWalksAdapter.notifyDataSetChanged();
    }

    @Override
    public View getAndroidView() {
        return rootView;
    }
}
