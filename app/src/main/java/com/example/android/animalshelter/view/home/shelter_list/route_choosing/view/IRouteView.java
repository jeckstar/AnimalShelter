package com.example.android.animalshelter.view.home.shelter_list.route_choosing.view;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.model.LocationPM;
import java.util.List;

public interface IRouteView {
    void showThatVolunteerTakeAnimalForAWalkSuccessfully();

    void showWarningMassage();

    void showSelectedItem(String animalKind, String animalName, String volunteerFirstName, String volunteerLastName);

    void drawPolyline(List<LocationPM> location);
}
