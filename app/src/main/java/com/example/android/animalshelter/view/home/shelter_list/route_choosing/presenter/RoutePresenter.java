package com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter;


import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.IRouteView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.Walk;
import com.jeka.golub.shelter.domain.walk.WalkRepository;
import com.jeka.golub.shelter.exeptions.WalkException;

import java.util.Date;
import java.util.concurrent.Executor;

public class RoutePresenter implements IRoutePresenter {

    private final VolunteerRepository volunteerRepository;
    private final AnimalRepository animalRepository;
    private final WalkRepository walkRepository;
    private final Executor executor;
    private final long currentAnimalId;
    private final long shelterId;
    private final long currentVolunteerId;
    private IRouteView view;

    public RoutePresenter(
            VolunteerRepository volunteerRepository,
            AnimalRepository animalRepository,
            WalkRepository walkRepository,
            Executor executor,
            long currentAnimal,
            long shelterId,
            long currentVolunteerId) {
        this.volunteerRepository = volunteerRepository;
        this.animalRepository = animalRepository;
        this.walkRepository = walkRepository;
        this.executor = executor;
        this.currentAnimalId = currentAnimal;
        this.shelterId = shelterId;
        this.currentVolunteerId = currentVolunteerId;
    }

    @Override
    public void onShowSelectedItem() {
        executor.execute(() -> {
            final Animal currentAnimal = animalRepository.getById(currentAnimalId);
            final Volunteer currentVolunteer = volunteerRepository.getById(currentVolunteerId);
            new Handler(Looper.getMainLooper()).post(() -> view.showSelectedItem(
                    currentAnimal.getKind(),
                    currentAnimal.getName(),
                    currentVolunteer.getFirstName(),
                    currentVolunteer.getLastName())
            );
        });
    }

    @Override
    public void onTakeAnimalForAWalk() {
        executor.execute(() -> {
            try {
                final Volunteer volunteer = volunteerRepository.getById(currentVolunteerId);
                final Date now = new Date();
                final Animal currentAnimal = animalRepository.getById(currentAnimalId);
                final Walk walk = volunteer.takeToTheWalk(currentAnimal, now);
                final Animal updateAnimal = currentAnimal.setLastWalkTime(now);
                walkRepository.add(walk);
                animalRepository.update(updateAnimal, shelterId);
                new Handler(Looper.getMainLooper()).post(() -> {
                    view.showThatVolunteerTakeAnimalForAWalkSuccessfully();
                });
            } catch (WalkException e) {
                e.printStackTrace();
                new Handler(Looper.getMainLooper()).post(view::showWarningMassage);
            }
        });
    }

    @Override
    public void attachView(IRouteView view) {
        this.view = view;
        onShowSelectedItem();
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
