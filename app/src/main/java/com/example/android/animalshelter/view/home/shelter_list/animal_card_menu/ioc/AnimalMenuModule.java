package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.presenter.AnimalCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.presenter.IAnimalCardPresenter;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.WalkRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
@AnimalMenuScope
public class AnimalMenuModule {

    private final long animalId;
    private final long shelterId;

    public AnimalMenuModule(long animalId,
                            long shelterId) {

        this.animalId = animalId;
        this.shelterId = shelterId;
    }

    @Provides
    @AnimalMenuScope
    public IAnimalCardPresenter getAnimalCardPresenter(VolunteerRepository volunteerRepository,
                                                       AnimalRepository animalRepository,
                                                       WalkRepository walkRepository
    ) {
        return new AnimalCardPresenter(
                volunteerRepository,
                animalRepository,
                walkRepository,
                Executors.newCachedThreadPool(),
                this.animalId,
                this.shelterId);
    }
}
