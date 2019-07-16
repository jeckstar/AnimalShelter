package com.example.android.animalshelter.view.home.create_shelter.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.view.home.create_shelter.CreateShelterEventConsumer;
import com.example.android.animalshelter.view.home.create_shelter.presenter.CreateShelterCardPresenter;
import com.example.android.animalshelter.view.home.create_shelter.presenter.ICreateShelterCardPresenter;
import com.example.android.animalshelter.view.home.create_shelter.view.CreateShelterCardView;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateShelterCardModule {

    private final CreateShelterCardView createShelterCardView;


    public CreateShelterCardModule(LayoutInflater inflater,
                                   ViewGroup container,
                                   Bundle savedInstanceState,
                                   CreateShelterEventConsumer consumer) {
        this.createShelterCardView = new CreateShelterCardView(
                inflater,
                container,
                savedInstanceState,
                consumer);

    }

    @Provides
    public CreateShelterCardView getShelterCardView() {
        return createShelterCardView;
    }

    @Provides
    public ICreateShelterCardPresenter getShelterCardPresenter(CreateShelterCardView view,
                                                               ShelterRepository shelterRepository) {
        return new CreateShelterCardPresenter(
                view,
                shelterRepository,
                Executors.newCachedThreadPool()
        );
    }
}
