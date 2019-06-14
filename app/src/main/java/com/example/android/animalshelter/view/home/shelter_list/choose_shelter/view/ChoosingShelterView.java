package com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.jeka.golub.shelter.domain.Shelter;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

public class ChoosingShelterView implements IChoosingShelterView {

    private final View rootView;
    private final List<Shelter> allShelters;
    private final AllSheltersRecyclerViewAdapter allSheltersAdapter;
    private final RecyclerView rvAllShelters;


    public ChoosingShelterView(@NonNull final LayoutInflater inflater, final ViewGroup container,
                               final Bundle savedInstanceState,
                               IOnItemClickListener<Shelter> chooseShelterListener) {
        rootView = inflater.inflate(R.layout.fragment_choosing_shelter, container, false);

        allShelters = new ArrayList<>();
        allSheltersAdapter = new AllSheltersRecyclerViewAdapter(
                allShelters,
                chooseShelterListener);
        rvAllShelters = rootView.findViewById(R.id.rv_choosing_screen_shelters);
        rvAllShelters.setAdapter(allSheltersAdapter);
        rvAllShelters.setLayoutManager(new LinearLayoutManager(rootView.getContext()));
    }

    @Override
    public View getAndroidView() {
        return rootView;
    }

    @Override
    public void updateShelterList(List<Shelter> newList) {
        allShelters.clear();
        allShelters.addAll(newList);
        allSheltersAdapter.notifyDataSetChanged();
    }
}
