package com.example.android.animalshelter.view.home.create_volunteer.ioc;

import com.example.android.animalshelter.view.home.create_volunteer.CreateVolunteerCardFragment;

import dagger.Subcomponent;

@Subcomponent(modules = {CreateVolunteerCardModule.class})
public interface CreateVolunteerSubcomponent {

    void inject(CreateVolunteerCardFragment fragment);
}
