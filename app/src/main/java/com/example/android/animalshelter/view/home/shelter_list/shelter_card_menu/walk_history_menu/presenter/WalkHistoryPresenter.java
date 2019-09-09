package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.view.IWalkHistoryView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.Walk;
import com.jeka.golub.shelter.domain.walk.WalkRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class WalkHistoryPresenter implements IWalkHistoryPresenter {

    private IWalkHistoryView view;
    private final WalkRepository walkRepository;
    private final AnimalRepository animalRepository;
    private final VolunteerRepository volunteerRepository;
    private final Executor executor;
    private final long currentAnimal;

    public WalkHistoryPresenter(WalkRepository walkRepository,
                                AnimalRepository animalRepository,
                                VolunteerRepository volunteerRepository,
                                Executor executor,
                                long currentAnimal) {
        this.walkRepository = walkRepository;
        this.animalRepository = animalRepository;
        this.volunteerRepository = volunteerRepository;
        this.executor = executor;
        this.currentAnimal = currentAnimal;
    }

    @Override
    public void onShowWalkHistory() {
        executor.execute(() -> {
            final List<Walk> walks = walkRepository.getAllWalkByAnimalId(currentAnimal);
            final Animal animal = animalRepository.getById(currentAnimal);
            for (Walk walk : walks) {
                walk.setCurrentAnimal(animal);
            }
            for (Walk walk : walks) {
                Volunteer volunteer = volunteerRepository.getById(walk.getVolunteerId());
                walk.setCurrentVolunteer(volunteer);
            }
            new Handler(Looper.getMainLooper()).post(() -> view.updateWalkList(walks));
        });
    }

    @Override
    public void attachView(IWalkHistoryView view) {
        this.view = view;
        onShowWalkHistory();
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
