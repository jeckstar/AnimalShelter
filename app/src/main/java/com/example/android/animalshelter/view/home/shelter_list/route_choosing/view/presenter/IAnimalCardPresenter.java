package com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.presenter;

import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.IAnimalCardView;
import com.example.android.animalshelter.view.presenter.Presenter;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

public interface IAnimalCardPresenter extends Presenter<IAnimalCardView> {

    void onShowAllVolunteersForCurrentShelter();

    void onShowSelectedAnimal();

    void onTakeAnimalForAWalk(Volunteer volunteer);
}
