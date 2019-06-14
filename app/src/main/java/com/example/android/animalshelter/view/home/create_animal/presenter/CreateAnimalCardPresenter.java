package com.example.android.animalshelter.view.home.create_animal.presenter;

import com.example.android.animalshelter.view.home.create_animal.view.ICreateAnimalCardView;
import com.jeka.golub.shelter.domain.Animal;
import com.jeka.golub.shelter.domain.repositories.AnimalRepository;

import java.util.concurrent.Executor;

public class CreateAnimalCardPresenter implements ICreateAnimalCardPresenter {

    private final ICreateAnimalCardView view;
    private final AnimalRepository animalRepository;
    private final Executor executor;
    private final long currentShelter;

    public CreateAnimalCardPresenter(ICreateAnimalCardView view, AnimalRepository animalRepository, Executor executor, long currentShelter) {
        this.view = view;
        this.animalRepository = animalRepository;
        this.executor = executor;
        this.currentShelter = currentShelter;
    }

    @Override
    public void onCreate() {

    }

    @Override
    public void onSaveCardClicked(String kind, String name, int age, int sex,  int walkPeriod) {
        executor.execute(() -> {
            Animal animal = new Animal(kind, name, age, sex, walkPeriod);
            animalRepository.add(animal, currentShelter);
        });
    }


}
