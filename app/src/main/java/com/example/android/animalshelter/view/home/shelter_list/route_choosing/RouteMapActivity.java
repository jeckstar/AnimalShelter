package com.example.android.animalshelter.view.home.shelter_list.route_choosing;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterActivity;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc.RouteViewFactory;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.presenter.IRoutePresenter;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.RouteView;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import javax.inject.Inject;

import androidx.appcompat.app.AppCompatActivity;

public class RouteMapActivity extends ShelterActivity implements OnMapReadyCallback {

    private static final String KEY_PARAMETERS = "PARAMETERS";

    @Inject
    IRoutePresenter presenter;
    @Inject
    RouteViewFactory factory;
    private RouteView view;
    private GoogleMap mMap;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_route_map);
        if (savedInstanceState == null) {
            Bundle bundle = this.getIntent().getExtras();
            final RouteMapActivityParameters parameters = bundle.getParcelable(KEY_PARAMETERS);
            getShelterApplication().dependencyInjection().openRouteScope(parameters.animalId, parameters.shelterId, parameters.volunteerId);
        }
        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getShelterApplication().dependencyInjection().inject(this);
        this.view = factory.createView(this);
        presenter.attachView(view);
    }

    /**
     * Manipulates the map once available.
     * This callback is triggered when the map is ready to be used.
     * This is where we can add markers or lines, add listeners or move the camera. In this case,
     * we just add a marker near Sydney, Australia.
     * If Google Play services is not installed on the device, the user will be prompted to install
     * it inside the SupportMapFragment. This method will only be triggered once the user has
     * installed Google Play services and returned to the app.
     */
    @Override
    public void onMapReady(GoogleMap googleMap) {
        mMap = googleMap;

        // Add a marker in Sydney and move the camera
        LatLng kharkov = new LatLng( 49.9902794,  36.2303893);
        mMap.addMarker(new MarkerOptions().position(kharkov).title("Marker in Kharkov"));
        mMap.moveCamera(CameraUpdateFactory.newLatLng(kharkov));
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
