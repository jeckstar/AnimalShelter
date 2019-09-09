package com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc;

import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.ChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.IChoosingShelterPresenter;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
@ChooseShelterScope
public class ChoosingShelterModule {

    @Provides
    @ChooseShelterScope
    public IChoosingShelterPresenter getChoosingShelterPresenter(ShelterRepository shelterRepository){
        return new ChoosingShelterPresenter(
                shelterRepository,
                Executors.newCachedThreadPool());
    }
}
