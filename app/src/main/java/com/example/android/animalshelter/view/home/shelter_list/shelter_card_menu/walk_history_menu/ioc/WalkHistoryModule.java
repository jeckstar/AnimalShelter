package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.ioc;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.presenter.IWalkHistoryPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.presenter.WalkHistoryPresenter;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.WalkRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
@WalkHistoryScope
public class WalkHistoryModule {

    private final long animalId;

    public WalkHistoryModule(long animalId) {
        this.animalId = animalId;
    }

    @Provides
    @WalkHistoryScope
    public IWalkHistoryPresenter getWalkHistoryPresenter(WalkRepository walkRepository,
                                                         AnimalRepository animalRepository,
                                                         VolunteerRepository volunteerRepository) {
        return new WalkHistoryPresenter(
                walkRepository,
                animalRepository,
                volunteerRepository, Executors.newCachedThreadPool(),
                animalId);
    }

}
