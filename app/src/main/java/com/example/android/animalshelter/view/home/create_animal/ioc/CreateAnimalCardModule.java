package com.example.android.animalshelter.view.home.create_animal.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.view.home.create_animal.CreateAnimalEventConsumer;
import com.example.android.animalshelter.view.home.create_animal.presenter.CreateAnimalCardPresenter;
import com.example.android.animalshelter.view.home.create_animal.presenter.ICreateAnimalCardPresenter;
import com.example.android.animalshelter.view.home.create_animal.view.CreateAnimalCardView;
import com.example.android.animalshelter.view.home.create_animal.view.ICreateAnimalCardView;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateAnimalCardModule {

    private final long currentShelter;
    private final ICreateAnimalCardView createAnimalCardView;

    public CreateAnimalCardModule(LayoutInflater inflater,
                                  ViewGroup container,
                                  Bundle savedInstanceState,
                                  CreateAnimalEventConsumer consumer,
                                  long currentShelter
    ) {
        this.currentShelter = currentShelter;
        this.createAnimalCardView = new CreateAnimalCardView(
                inflater,
                container,
                savedInstanceState,
                consumer);
    }

    @Provides
    public ICreateAnimalCardView getCreateAnimalCardView() {
        return createAnimalCardView;
    }

    @Provides
    public ICreateAnimalCardPresenter getAnimalCardPresenter(ICreateAnimalCardView view,
                                                             AnimalRepository animalRepository
    ) {
        return new CreateAnimalCardPresenter(
                view,
                animalRepository,
                Executors.newCachedThreadPool(),
                this.currentShelter);
    }

}


