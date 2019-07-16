package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter.IShelterCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.presenter.ShelterCardPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.IShelterCardView;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.view.ShelterCardView;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
public class ShelterCardMenuModule {

    private final IShelterCardView view;
    private final long shelterId;

    public ShelterCardMenuModule(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState,
                                 IOnItemClickListener<Animal> animalIOnItemClickListener,
                                 long shelterId) {

        view = new ShelterCardView(
                inflater,
                container,
                savedInstanceState,
                animalIOnItemClickListener);
        this.shelterId = shelterId;

    }

    @Provides
    public IShelterCardView getView() {
        return view;
    }

    @Provides
    public IShelterCardPresenter getShelterCardPresenter(IShelterCardView view,
                                                         AnimalRepository animalRepository){
        return new ShelterCardPresenter(
                view,
                animalRepository,
                Executors.newCachedThreadPool(),
                shelterId
        );
    }
}
