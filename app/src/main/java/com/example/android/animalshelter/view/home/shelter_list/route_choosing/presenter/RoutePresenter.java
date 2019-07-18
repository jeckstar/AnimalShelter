package com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter;


import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.IRouteView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
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
    private IRouteView view;

    public RoutePresenter(
            VolunteerRepository volunteerRepository,
            AnimalRepository animalRepository,
            WalkRepository walkRepository,
            Executor executor,
            long currentAnimal,
            long shelterId,
            long volunteerId) {
        this.volunteerRepository = volunteerRepository;
        this.animalRepository = animalRepository;
        this.walkRepository = walkRepository;
        this.executor = executor;
        this.currentAnimalId = currentAnimal;
        this.shelterId = shelterId;
    }

    @Override
    public void attachView(IRouteView view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void onTakeAnimalForAWalk() {
        executor.execute(() -> {
            try {
//                volunteerRepository;
//                final Date now = new Date();
//                final Animal currentAnimal = animalRepository.getById(currentAnimalId);
////                final Walk walk = volunteer.takeToTheWalk(currentAnimal, now);
//                final Animal updateAnimal = currentAnimal.setLastWalkTime(now);
////                walkRepository.add(walk);
//                animalRepository.update(updateAnimal, shelterId);
//                new Handler(Looper.getMainLooper()).post(() -> {
//                    view.showThatVolunteerTakeAnimalForAWalkSuccessfully();
//                });
            } catch (WalkException e) {
                e.printStackTrace();
                new Handler(Looper.getMainLooper()).post(view::showWarningMassage);
            }
        });
    }
}
