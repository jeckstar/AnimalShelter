package com.example.android.animalshelter.view.home.shelter_list.route_choosing;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterActivity;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc.RouteViewFactory;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter.IRoutePresenter;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.RouteView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class RouteMapActivity extends ShelterActivity implements OnMapReadyCallback {

    private static final String KEY_PARAMETERS = "PARAMETERS";
    private static final String TAG = "click";
    private final List<Marker> markers = new ArrayList<>();

    @Inject
    IRoutePresenter presenter;
    @Inject
    RouteViewFactory factory;
    private RouteView view;
    private GoogleMap mMap;

    private IUserLocation userLocation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);
        if (savedInstanceState == null) {
            Bundle bundle = this.getIntent().getExtras();
            final RouteMapActivityParameters parameters = bundle.getParcelable(KEY_PARAMETERS);
            getShelterApplication().dependencyInjection().openRouteScope(
                    parameters.animalId,
                    parameters.shelterId,
                    parameters.volunteerId
            );
        }
        userLocation = new UserLocation(this);
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getShelterApplication().dependencyInjection().inject(this);
        this.view = factory.createView(
                this,
                v -> removeLastAddedMarker(),
                v -> removeAllMarkers());


        presenter.attachView(view);
        userLocation.findLocation();
    }

    @Override
    protected void onResume() {
        super.onResume();
        userLocation.findLocation();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;
        userLocation.attachMap(mMap);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                return;
            }
        }
        mMap.getUiSettings().setMyLocationButtonEnabled(true);
        mMap.setMyLocationEnabled(true);
        if (mMap != null) {
            init();
        }
    }

    private void init() {
        mMap.setOnMapClickListener(latLng -> {
            Log.d(TAG, "onMapClick: " + latLng.latitude + "," + latLng.longitude);
            addMarker(latLng);
        });
        mMap.setOnMarkerClickListener(marker -> {
            marker.showInfoWindow();
            return false;
        });
        mMap.setOnMapLongClickListener(new GoogleMap.OnMapLongClickListener() {
            @Override
            public void onMapLongClick(LatLng latLng) {
                Log.d(TAG, "onMapLongClick: " + latLng.latitude + "," + latLng.longitude);
            }
        });
    }

    public void addMarker(LatLng latLng) {
        markers.add(mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .anchor((float) 0.5, 0)
                .title("Marker"))
        );
    }

    public void removeLastAddedMarker() {
        if(markers.isEmpty()){
            return;
        }
        markers.remove(markers.size() - 1).remove();
    }

    public void removeAllMarkers() {
        if(markers.isEmpty()){
            return;
        }
        for (int i = 0; i < markers.size(); i++) {
            markers.get(i).remove();
        }
        markers.clear();
    }


    public static void push(Context context, long animalId, long shelterId, long volunteerId) {
        Intent intent = new Intent(context, RouteMapActivity.class);
        intent.putExtra(KEY_PARAMETERS, new RouteMapActivityParameters(animalId, shelterId, volunteerId));
        context.startActivity(intent);
    }

    private static class RouteMapActivityParameters implements Parcelable {
        private final long animalId;
        private final long shelterId;
        private final long volunteerId;

        public RouteMapActivityParameters(long animalId, long shelterId, long volunteerId) {
            this.animalId = animalId;
            this.shelterId = shelterId;
            this.volunteerId = volunteerId;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeLong(animalId);
            dest.writeLong(shelterId);
            dest.writeLong(volunteerId);
        }

        @Override
        public int describeContents() {
            return 0;
        }

        public static final Creator<RouteMapActivityParameters> CREATOR = new Creator<RouteMapActivityParameters>() {
            @Override
            public RouteMapActivityParameters createFromParcel(Parcel in) {
                return new RouteMapActivityParameters(in.readLong(), in.readLong(), in.readLong());
            }

            @Override
            public RouteMapActivityParameters[] newArray(int size) {
                return new RouteMapActivityParameters[size];
            }
        };

        public long getAnimalId() {
            return animalId;
        }

        public long getShelterId() {
            return shelterId;
        }

        public long getVolunteerId() {
            return volunteerId;
        }
    }

}
