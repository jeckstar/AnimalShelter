package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.IAnimalCardView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.Walk;
import com.jeka.golub.shelter.domain.walk.WalkRepository;
import com.jeka.golub.shelter.exeptions.WalkException;

import java.util.Date;
import java.util.List;
import java.util.concurrent.Executor;

public class AnimalCardPresenter implements IAnimalCardPresenter {
    private final IAnimalCardView view;
    private final VolunteerRepository volunteerRepository;
    private final AnimalRepository animalRepository;
    private final WalkRepository walkRepository;
    private final Executor executor;
    private final long currentAnimalId;
    private final long shelterId;
    private Animal currentAnimal;


    public AnimalCardPresenter(
            IAnimalCardView view,
            VolunteerRepository volunteerRepository,
            AnimalRepository animalRepository,
            WalkRepository walkRepository,
            Executor executor,
            long currentAnimal,
            long shelterId) {
        this.view = view;
        this.volunteerRepository = volunteerRepository;
        this.animalRepository = animalRepository;
        this.walkRepository = walkRepository;
        this.executor = executor;
        this.currentAnimalId = currentAnimal;
        this.shelterId = shelterId;
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
        executor.execute(() -> {
            try {
                final Date now = new Date();
                final Walk walk = volunteer.takeToTheWalk(currentAnimal, now);
                currentAnimal.setLastWalkTime(now);
                walkRepository.add(walk);
                animalRepository.update(currentAnimal, shelterId);
                new Handler(Looper.getMainLooper()).post(() -> {
                    view.showThatVolunteerTakeAnimalForAWalkSuccessfully();
                    onShowSelectedAnimal();
                });
            } catch (WalkException e) {
                e.printStackTrace();
                new Handler(Looper.getMainLooper()).post(view::showWarningMassage);
            }
        });
    }
}