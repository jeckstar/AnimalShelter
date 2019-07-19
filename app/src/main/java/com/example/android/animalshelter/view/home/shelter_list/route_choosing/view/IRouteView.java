package com.example.android.animalshelter.view.home.shelter_list.route_choosing.view;

public interface IRouteView {
    void showThatVolunteerTakeAnimalForAWalkSuccessfully();

    void showWarningMassage();

    void showSelectedItem(String animalKind, String animalName, String volunteerFirstName, String volunteerLastName);
}
