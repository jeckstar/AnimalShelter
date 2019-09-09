package com.example.android.animalshelter.dagger;


import com.example.android.animalshelter.view.home.create_animal.ioc.CreateAnimalCardModule;
import com.example.android.animalshelter.view.home.create_animal.ioc.CreateAnimalCardSubcomponent;
import com.example.android.animalshelter.view.home.create_shelter.ioc.CreateShelterCardModule;
import com.example.android.animalshelter.view.home.create_shelter.ioc.CreateShelterSubcomponent;
import com.example.android.animalshelter.view.home.create_volunteer.ioc.CreateVolunteerCardModule;
import com.example.android.animalshelter.view.home.create_volunteer.ioc.CreateVolunteerSubcomponent;
import com.example.android.animalshelter.view.home.main_screen.ioc.HomeScreenSubcomponent;
import com.example.android.animalshelter.view.home.main_screen.ioc.ShelterHomeScreenModule;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.ioc.MainMenuModule;
import com.example.android.animalshelter.view.home.main_screen.main_menu_fragment.ioc.MainMenuSubcomponent;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc.AnimalMenuModule;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.ioc.AnimalMenuSubcomponent;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc.ChoosingShelterModule;
import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.ioc.ChoosingShelterSubcomponent;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc.RouteModule;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc.RouteSubcomponent;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc.ShelterCardMenuModule;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.ioc.ShelterCardMenuSubcomponent;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.ioc.RouteDisplayModule;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.ioc.RouteDisplaySubcomponent;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.ioc.WalkHistoryModule;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.walk_history_menu.ioc.WalkHistorySubcomponent;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {ShelterApplicationModule.class, InfrastructureModule.class, HttpClientModule.class})
public interface ShelterComponent {

    CreateAnimalCardSubcomponent subcomponent(CreateAnimalCardModule module);

    CreateShelterSubcomponent subcomponent(CreateShelterCardModule module);

    CreateVolunteerSubcomponent subcomponent(CreateVolunteerCardModule module);

    HomeScreenSubcomponent subcomponent(ShelterHomeScreenModule module);

    MainMenuSubcomponent subcomponent(MainMenuModule module);

    AnimalMenuSubcomponent subcomponent(AnimalMenuModule module);

    ChoosingShelterSubcomponent subcomponent(ChoosingShelterModule module);

    ShelterCardMenuSubcomponent subcomponent(ShelterCardMenuModule module);

    RouteSubcomponent subcomponent(RouteModule module);

    WalkHistorySubcomponent subcomponent(WalkHistoryModule module);

    RouteDisplaySubcomponent subcomponent(RouteDisplayModule module);
}



