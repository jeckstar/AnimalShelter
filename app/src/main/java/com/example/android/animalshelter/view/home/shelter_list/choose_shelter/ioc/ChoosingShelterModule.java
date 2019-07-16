package com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.ChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter.IChoosingShelterPresenter;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.ChoosingShelterView;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.IChoosingShelterView;
import com.jeka.golub.shelter.domain.shelter.Shelter;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
public class ChoosingShelterModule {

    private final IChoosingShelterView view;

    public ChoosingShelterModule(LayoutInflater inflater,
                                 ViewGroup container,
                                 Bundle savedInstanceState,
                                 IOnItemClickListener<Shelter> shelterIOnItemClickListener) {

        view = new ChoosingShelterView(
                inflater,
                container,
                savedInstanceState,
                shelterIOnItemClickListener);
    }

    @Provides
    public IChoosingShelterView getView() {
        return view;
    }

    @Provides
    public IChoosingShelterPresenter getChoosingShelterPresenter(IChoosingShelterView view,
                                                                 ShelterRepository shelterRepository){
        return new ChoosingShelterPresenter(
                view,
                shelterRepository,
                Executors.newCachedThreadPool());
    }
}
