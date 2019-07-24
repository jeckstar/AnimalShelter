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
//        List<LatLng> latLngs = new ArrayList<>();
//        double[] latitudes = {
//                40.203735,
//                40.203617,
//                40.203617,
//                40.203571,
//                40.203571,
//                40.212993,
//                40.212993,
//                40.222515,
//                40.222515,
//                40.222,
//                40.222,
//                40.227867,
//                40.227867,
//                40.227539,
//                40.227539,
//                40.221908,
//                40.221908,
//                40.249027,
//                40.249027,
//                40.304954,
//                40.304954,
//                40.301498,
//                40.301498,
//                40.364498,
//                40.368495,
//                40.382682,
//                40.397239,
//                40.430889,
//                40.471801,
//                40.480957,
//                40.479011,
//                40.493789,
//                40.498321,
//                40.526847,
//                40.564601,
//                40.57061,
//                40.539234,
//                40.556442,
//                40.594371,
//                40.611503,
//                40.579284,
//                40.622348,
//                40.653442,
//                40.668922,
//                40.683479,
//                40.703529,
//                40.727935,
//                40.732955,
//                40.760101,
//                40.794662,
//                40.798587,
//                40.779037,
//                40.779037,
//                40.778633,
//                40.778633,
//                40.777702,
//        };
//        double[] longitude = {
//                -76.729667,
//                -76.729705,
//                -76.729705,
//                -76.733085,
//                -76.733085,
//                -76.735542,
//                -76.735542,
//                -76.753242,
//                -76.753242,
//                -76.754974,
//                -76.754974,
//                -76.757873,
//                -76.757873,
//                -76.761886,
//                -76.761886,
//                -76.783859,
//                -76.783859,
//                -76.812561,
//                -76.812561,
//                -76.83039,
//                -76.83039,
//                -76.872665,
//                -76.872665,
//                -76.92881,
//                -76.981414,
//                -77.016967,
//                -77.008132,
//                -77.010658,
//                -77.032135,
//                -77.049224,
//                -77.068656,
//                -77.082611,
//                -77.126365,
//                -77.134216,
//                -77.169754,
//                -77.243759,
//                -77.341888,
//                -77.362098,
//                -77.377586,
//                -77.445732,
//                -77.551391,
//                -77.580848,
//                -77.583488,
//                -77.604171,
//                -77.607658,
//                -77.597267,
//                -77.604621,
//                -77.63565,
//                -77.614212,
//                -77.625228,
//                -77.656425,
//                -77.771057,
//                -77.771057,
//                -77.793205,
//                -77.793205,
//                -77.793266
//        };
//        for (int i = 0; i < latitudes.length; i++) {
//            latLngs.add(new LatLng(latitudes[i], longitude[i]));
//        }

//        map.addPolyline(new PolylineOptions().addAll(latLngs));
//        map.addPolyline(new PolylineOptions().addAll(
//                StreamSupport.stream(locationPMS)
//                        .map(LocationPM::asLatLng)
//                        .collect(Collectors.toList())
//        ));


//        40.20356750488281, -76.7297134399414
//        40.20086669921875, -76.72824096679688
//        40.20221710205078, -76.72897720336914
//        40.20086669921875, -76.72824096679688
//        40.19868087768555, -76.75468444824219
//        40.19977378845215, -76.74146270751953
    }

    public void withMap(GoogleMap googleMap) {
        this.map = googleMap;
    }
}
