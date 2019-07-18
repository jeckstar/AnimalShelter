package com.example.android.animalshelter.view.home.shelter_list.route_choosing.view;

import android.widget.Toast;

import androidx.fragment.app.FragmentActivity;

public class RouteView implements IRouteView {

    private final FragmentActivity rootView;

    public RouteView(FragmentActivity fragmentActivity) {
        rootView = fragmentActivity;
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
}
