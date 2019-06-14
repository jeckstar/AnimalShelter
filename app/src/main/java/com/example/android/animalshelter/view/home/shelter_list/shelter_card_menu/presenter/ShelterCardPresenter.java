package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.IShelterCardView;
import com.jeka.golub.shelter.domain.Animal;
import com.jeka.golub.shelter.domain.repositories.AnimalRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class ShelterCardPresenter implements IShelterCardPresenter {
    private final IShelterCardView view;
    private final AnimalRepository animalRepository;
    private final Executor executor;
    private final long currentShelter;


    public ShelterCardPresenter(IShelterCardView view, AnimalRepository animalRepository, Executor executor, long currentShelter) {
        this.view = view;
        this.animalRepository = animalRepository;
        this.executor = executor;
        this.currentShelter = currentShelter;
    }

    @Override
    public void onCreate() {
        onShowAllAnimalsForCurrentShelter();
    }

    @Override
    public void onShowAllAnimalsForCurrentShelter() {
        executor.execute(() -> {
            final List<Animal> animals = animalRepository.getAllForCurrentShelter(currentShelter);
            new Handler(Looper.getMainLooper()).post(() -> view.updateAnimalList(animals));
        });
    }
}
