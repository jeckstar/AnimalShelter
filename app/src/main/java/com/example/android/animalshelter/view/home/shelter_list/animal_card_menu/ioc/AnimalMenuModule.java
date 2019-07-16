package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter.AnimalCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter.IAnimalCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.AnimalCardView;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.IAnimalCardView;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.WalkRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
public class AnimalMenuModule {

    private final IAnimalCardView view;
    private final long animalId;
    private final long shelterId;

    public AnimalMenuModule(LayoutInflater inflater,
                            ViewGroup container,
                            Bundle savedInstanceState,
                            IOnItemClickListener<Volunteer> volunteerIOnItemClickListener,
                            long animalId,
                            long shelterId) {

        view = new AnimalCardView(
                inflater,
                container,
                savedInstanceState,
                volunteerIOnItemClickListener);
        this.animalId = animalId;
        this.shelterId = shelterId;
    }

    @Provides
    public IAnimalCardView getView() {
        return this.view;
    }

    @Provides
    public IAnimalCardPresenter getAnimalCardPresenter(IAnimalCardView view,
                                                       VolunteerRepository volunteerRepository,
                                                       AnimalRepository animalRepository,
                                                       WalkRepository walkRepository
                                                       ) {
        return new AnimalCardPresenter(
                view,
                volunteerRepository,
                animalRepository,
                walkRepository,
                Executors.newCachedThreadPool(),
                this.animalId,
                this.shelterId);
    }
}
