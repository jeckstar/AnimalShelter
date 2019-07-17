package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc;

import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter.IShelterCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter.ShelterCardPresenter;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
@ShelterMenuScope
public class ShelterCardMenuModule {

    private final long shelterId;

    public ShelterCardMenuModule(long shelterId) {
        this.shelterId = shelterId;
    }

    @Provides
    @ShelterMenuScope
    public IShelterCardPresenter getShelterCardPresenter(AnimalRepository animalRepository) {
        return new ShelterCardPresenter(
                animalRepository,
                Executors.newCachedThreadPool(),
                shelterId
        );
    }
}
