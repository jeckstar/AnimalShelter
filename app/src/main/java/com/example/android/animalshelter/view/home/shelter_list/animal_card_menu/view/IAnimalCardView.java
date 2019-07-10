package com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view;

import android.view.View;

import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

import java.util.Date;
import java.util.List;

public interface IAnimalCardView {

    View getAndroidView();

    void updateVolunteerList(List<Volunteer> volunteers);

    void showSelectedAnimal(String kind, String name, Date lastWalkTime, int walkPeriod);
}
