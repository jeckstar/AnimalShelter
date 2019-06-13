package com.example.android.animalshelter.view.home.create_shelter.presenter;

import com.example.android.animalshelter.view.home.create_shelter.view.ICreateShelterCardView;
import com.jeka.golub.shelter.domain.Shelter;
import com.jeka.golub.shelter.domain.repositories.ShelterRepository;

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
    public void onCreate() {

    }

    @Override
    public void onSaveCardClicked(String title, String address, String phoneNumber) {
        executor.execute(()->{
            Shelter shelter = new Shelter(title, address, phoneNumber);
            shelterRepositories.add(shelter);
        });
        view.showThatShelterWasCreatedSuccessfully();
    }

}
