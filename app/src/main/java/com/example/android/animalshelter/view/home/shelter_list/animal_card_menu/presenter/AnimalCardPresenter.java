package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.IAnimalCardView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class AnimalCardPresenter implements IAnimalCardPresenter{
    private final IAnimalCardView view;
    private final VolunteerRepository volunteerRepository;
    private final AnimalRepository animalRepository;
    private final Executor executor;
    private final long currentAnimalId;
    private Animal currentAnimal;


    public AnimalCardPresenter(IAnimalCardView view, VolunteerRepository volunteerRepository, AnimalRepository animalRepository, Executor executor, long currentAnimal) {
        this.view = view;
        this.volunteerRepository = volunteerRepository;
        this.animalRepository = animalRepository;
        this.executor = executor;
        this.currentAnimalId = currentAnimal;
    }

    @Override
    public void onCreate() {
        onShowAllVolunteetsForCurrentShelter();
        onShowSelectedAnimal();
    }

    @Override
    public void onShowAllVolunteetsForCurrentShelter() {
        executor.execute(() -> {
            final List<Volunteer> volunteers = volunteerRepository.getAll();
            new Handler(Looper.getMainLooper()).post(() -> view.updateVolunteerList(volunteers));
        });
    }

    @Override
    public void onShowSelectedAnimal() {
        executor.execute(() -> {
            currentAnimal = animalRepository.getById(currentAnimalId);
            new Handler(Looper.getMainLooper()).post(() -> view.showSelectedAnimal(
                    currentAnimal.getKind(),
                    currentAnimal.getName(),
                    currentAnimal.getLastWalkTime(),
                    currentAnimal.getWalkPeriod())
            );
        });
    }

    @Override
    public void onTakeAnimalForAWalk(Volunteer volunteer) {
        volunteer.takeToTheWalk(currentAnimal);
    }
}
