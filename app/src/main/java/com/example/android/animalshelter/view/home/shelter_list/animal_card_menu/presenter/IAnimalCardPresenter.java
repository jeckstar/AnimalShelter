package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.presenter;

import com.jeka.golub.shelter.domain.volunteer.Volunteer;

public interface IAnimalCardPresenter {
    void onCreate();

    void onShowAllVolunteersForCurrentShelter();

    void onShowSelectedAnimal();

    void onTakeAnimalForAWalk(Volunteer volunteer);
}
