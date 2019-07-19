package com.example.android.animalshelter.view.home.shelter_list.route_choosing.view;

import android.widget.TextView;
import android.widget.Toast;

import com.example.android.animalshelter.R;

import androidx.fragment.app.FragmentActivity;

public class RouteView implements IRouteView {

    private final FragmentActivity rootView;
    private final TextView tvKind;
    private final TextView tvAnimalName;
    private final TextView tvVolunteerFirstName;
    private final TextView tvVolunteerLastName;

    public RouteView(FragmentActivity fragmentActivity) {
        rootView = fragmentActivity;
        tvKind = rootView.findViewById(R.id.tv_map_animal_kind);
        tvAnimalName = rootView.findViewById(R.id.tv_map_animal_name);
        tvVolunteerFirstName = rootView.findViewById(R.id.tv_map_volunteer_first_name);
        tvVolunteerLastName = rootView.findViewById(R.id.tv_map_volunteer_last_name);
    }


    @Override
    public void showThatVolunteerTakeAnimalForAWalkSuccessfully() {
        Toast
                .makeText(
                        rootView.getApplicationContext().getApplicationContext(),
                        "Ups! It is not time to walk yet.",
                        Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showWarningMassage() {
        Toast
                .makeText(
                        rootView.getApplicationContext().getApplicationContext(),
                        "Walking is started",
                        Toast.LENGTH_SHORT)
                .show();
    }

    @Override
    public void showSelectedItem(String animalKind, String animalName, String volunteerFirstName, String volunteerLastName) {
        tvKind.setText(animalKind);
        tvAnimalName.setText(animalName);
        tvVolunteerFirstName.setText(volunteerFirstName);
        tvVolunteerLastName.setText(volunteerLastName);
    }
}
