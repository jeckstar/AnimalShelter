package com.example.android.animalshelter.view.home.shelter_list.route_choosing.view;

import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.model.LocationPM;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.List;

import androidx.fragment.app.FragmentActivity;
import java9.util.stream.Collectors;
import java9.util.stream.StreamSupport;

public class RouteView implements IRouteView {

    private final FragmentActivity rootView;
    private final TextView tvKind;
    private final TextView tvAnimalName;
    private final TextView tvVolunteerFirstName;
    private final TextView tvVolunteerLastName;
    private GoogleMap map;

    public RouteView(FragmentActivity fragmentActivity,
                     View.OnClickListener onRemoveLastAddedMarker,
                     View.OnClickListener onRemoveAllMarkers) {
        rootView = fragmentActivity;
        tvKind = rootView.findViewById(R.id.tv_map_animal_kind);
        tvAnimalName = rootView.findViewById(R.id.tv_map_animal_name);
        tvVolunteerFirstName = rootView.findViewById(R.id.tv_map_volunteer_first_name);
        tvVolunteerLastName = rootView.findViewById(R.id.tv_map_volunteer_last_name);
        rootView.findViewById(R.id.iv_map_remove_marker).setOnClickListener(onRemoveLastAddedMarker);
        rootView.findViewById(R.id.iv_map_remove_all_markers).setOnClickListener(onRemoveAllMarkers);
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

    @Override
    public void drawPolyline(List<LocationPM> locations) {
        map.addPolyline(new PolylineOptions().addAll(
                StreamSupport.stream(locations)
                        .map(LocationPM::asLatLng)
                        .collect(Collectors.toList())
        ));
    }

    public void withMap(GoogleMap googleMap) {
        this.map = googleMap;
    }
}
