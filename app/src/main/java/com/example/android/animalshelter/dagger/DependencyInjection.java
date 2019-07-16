package com.example.android.animalshelter.dagger;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.create_animal.CreateAnimalCardFragment;
import com.example.android.animalshelter.view.home.create_animal.CreateAnimalEventConsumer;
import com.example.android.animalshelter.view.home.create_animal.ioc.CreateAnimalCardModule;
import com.example.android.animalshelter.view.home.create_shelter.CreateShelterCardFragment;
import com.example.android.animalshelter.view.home.create_shelter.CreateShelterEventConsumer;
import com.example.android.animalshelter.view.home.create_shelter.ioc.CreateShelterCardModule;
import com.example.android.animalshelter.view.home.create_volunteer.CreateVolunteerCardFragment;
import com.example.android.animalshelter.view.home.create_volunteer.CreateVolunteerEventConsumer;
import com.example.android.animalshelter.view.home.create_volunteer.ioc.CreateVolunteerCardModule;
import com.example.android.animalshelter.view.home.main_screen.ShelterHomeScreenActivity;
import com.example.android.animalshelter.view.home.main_screen.ioc.ShelterHomeScreenModule;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.MainMenuFragment;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.ioc.MainMenuModule;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.AnimalMenuFragment;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc.AnimalMenuModule;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ChoosingShelterFragment;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc.ChoosingShelterModule;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ShelterCardMenuFragment;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc.ShelterCardMenuModule;
import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.shelter.Shelter;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

public class DependencyInjection {

    private final ShelterComponent component;

    public DependencyInjection(Context context) {
        this.component = DaggerShelterComponent.builder().shelterApplicationModule(new ShelterApplicationModule(context)).build();
    }

    public void inject(CreateAnimalCardFragment fragment,
                       LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState,
                       CreateAnimalEventConsumer consumer,
                       long currentShelter) {
        this.component.subcomponent(
                new CreateAnimalCardModule(
                        inflater,
                        container,
                        savedInstanceState,
                        consumer,
                        currentShelter))
                .inject(fragment);
    }

    public void inject(CreateShelterCardFragment fragment,
                       LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState,
                       CreateShelterEventConsumer consumer) {
        this.component.subcomponent(
                new CreateShelterCardModule(
                        inflater,
                        container,
                        savedInstanceState,
                        consumer))
                .inject(fragment);
    }

    public void inject(CreateVolunteerCardFragment fragment,
                       LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState,
                       CreateVolunteerEventConsumer consumer) {
        this.component.subcomponent(
                new CreateVolunteerCardModule(
                        inflater,
                        container,
                        savedInstanceState,
                        consumer))
                .inject(fragment);
    }

    public void inject(ShelterHomeScreenActivity activity) {
        this.component.subcomponent(
                new ShelterHomeScreenModule(activity))
                .inject(activity);
    }

    public void inject(MainMenuFragment fragment) {
        this.component.subcomponent(
                new MainMenuModule(fragment))
                .inject(fragment);
    }

    public void inject(AnimalMenuFragment fragment,
                       LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState,
                       IOnItemClickListener<Volunteer> volunteerIOnItemClickListener, long animalId, long shelterId) {
        this.component.subcomponent(
                new AnimalMenuModule(
                        inflater,
                        container,
                        savedInstanceState,
                        volunteerIOnItemClickListener,
                        animalId,
                        shelterId))
                .inject(fragment);
    }

    public void inject(ChoosingShelterFragment fragment,
                       LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState,
                       IOnItemClickListener<Shelter> shelterIOnItemClickListener) {
        this.component.subcomponent(
                new ChoosingShelterModule(
                        inflater,
                        container,
                        savedInstanceState,
                        shelterIOnItemClickListener))
                .inject(fragment);
    }

    public void inject(ShelterCardMenuFragment fragment,
                       LayoutInflater inflater,
                       ViewGroup container,
                       Bundle savedInstanceState,
                       IOnItemClickListener<Animal> animalIOnItemClickListener,
                       long shelterId) {
        this.component.subcomponent(
                new ShelterCardMenuModule(
                        inflater,
                        container,
                        savedInstanceState,
                        animalIOnItemClickListener,
                        shelterId))
                .inject(fragment);
    }

}
