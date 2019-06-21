package com.example.android.animalshelter.view.home.create_shelter.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.create_shelter.view.ICreateShelterCardView;
import com.jeka.golub.shelter.domain.shelter.Shelter;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

import java.util.ArrayList;
import java.util.concurrent.Executor;

public class CreateShelterCardPresenter implements ICreateShelterCardPresenter {

    private final ICreateShelterCardView view;
    private final ShelterRepository shelterRepositories;
    private final Executor executor;


    public CreateShelterCardPresenter(ICreateShelterCardView view, ShelterRepository shelterRepositories, Executor executor) {
        this.view = view;
        this.shelterRepositories = shelterRepositories;
        this.executor = executor;
    }


    @Override
    public void onSaveCardClicked(String title, String address, String phoneNumber) {
        executor.execute(() -> {
            Shelter shelter = new Shelter(title, address, phoneNumber, new ArrayList<>());
            shelterRepositories.add(shelter);
            new Handler(Looper.getMainLooper()).post(view::showThatShelterWasCreatedSuccessfully);
        });
    }

}
