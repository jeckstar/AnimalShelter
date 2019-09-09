package com.example.android.animalshelter.view.home.create_volunteer.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.view.home.create_shelter.CreateShelterEventConsumer;
import com.example.android.animalshelter.view.home.create_shelter.presenter.ICreateShelterCardPresenter;
import com.example.android.animalshelter.view.home.create_volunteer.CreateVolunteerEventConsumer;
import com.example.android.animalshelter.view.home.create_volunteer.presenter.CreateVolunteerCardPresenter;
import com.example.android.animalshelter.view.home.create_volunteer.presenter.ICreateVolunteerCardPresenter;
import com.example.android.animalshelter.view.home.create_volunteer.view.CreateVolunteerCardView;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;

import java.util.concurrent.Executors;

import dagger.Module;
import dagger.Provides;

@Module
public class CreateVolunteerCardModule {

    private final CreateVolunteerCardView view;

    public CreateVolunteerCardModule(LayoutInflater inflater,
                                     ViewGroup container,
                                     Bundle savedInstanceState,
                                     CreateVolunteerEventConsumer consumer) {
        this.view = new CreateVolunteerCardView(
                inflater,
                container,
                savedInstanceState,
                consumer);
    }

    @Provides
    public CreateVolunteerCardView getCreateVolunteerCardView(){
        return this.view;
    }

    @Provides
    public ICreateVolunteerCardPresenter getVolunteerCardPresenter(CreateVolunteerCardView view,
                                                                   VolunteerRepository repository){
        return new CreateVolunteerCardPresenter(
                view,
                repository,
                Executors.newCachedThreadPool()
        );
    }
}
