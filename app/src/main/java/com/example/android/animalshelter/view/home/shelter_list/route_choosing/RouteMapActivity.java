package com.example.android.animalshelter.view.home.shelter_list.route_choosing;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.util.Log;
import android.widget.Toast;

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
import com.jeka.golub.shelter.domain.route.Location;

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
    private boolean isNetConnected = false;
    private NetworkChangeReceiver receiver;

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
        SupportMapFragment mapFragment = (SupportMapFragment) getSupportFragmentManager()
                .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
        getShelterApplication().dependencyInjection().inject(this);
        this.view = factory.createView(
                this,
                v -> removeLastAddedMarker(),
                v -> removeAllMarkers(),
                v -> presenter.onTakeAnimalForAWalk()
        );

        presenter.onCreate(UserLocation.create(getApplicationContext()), view);
        initBroadcastReceiver();
    }

    private void initBroadcastReceiver() {
        receiver = new NetworkChangeReceiver(aBoolean -> {
            isNetConnected = aBoolean;
            Log.i("NET_CONNECTING", isNetConnected + "");
        });
        IntentFilter filter = new IntentFilter();
        filter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
        registerReceiver(receiver, filter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.findLocation();
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        view.withMap(googleMap);
        mMap = googleMap;
        presenter.attachMap(mMap);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && checkSelfPermission(Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(getShelterApplication().getApplicationContext(), "Please, allow location permissions", Toast.LENGTH_LONG).show();
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
        mMap.setOnMapLongClickListener(latLng -> Log.d(TAG, "onMapLongClick: " + latLng.latitude + "," + latLng.longitude));
    }

    public void addMarker(LatLng latLng) {
        markers.add(mMap.addMarker(new MarkerOptions()
                .position(latLng)
                .anchor((float) 0.5, 0)
                .title("Marker"))
        );
        int markerPosition = markers.size() - 1;
        if (markerPosition != 0) {
            onCreateRoute(markerPosition);
        }
    }

    private void onCreateRoute(int markerPosition) {
        LatLng fromLatLng = markers.get(markerPosition).getPosition();
        LatLng toLatLng = markers.get(markerPosition - 1).getPosition();
        try {
            presenter.onCreateRoute(
                    Location.createLocation(toLatLng.latitude, toLatLng.longitude),
                    Location.createLocation(fromLatLng.latitude, fromLatLng.longitude));
        } catch (Exception e) {
            Toast.makeText(getShelterApplication().getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void removeLastAddedMarker() {
        if (markers.isEmpty()) {
            return;
        }
        markers.remove(markers.size() - 1).remove();
    }

    public void removeAllMarkers() {
        if (markers.isEmpty()) {
            return;
        }
        for (int i = 0; i < markers.size(); i++) {
            markers.get(i).remove();
        }
        mMap.clear();
        markers.clear();
    }

    public static void push(Context context, long animalId, long shelterId, long volunteerId) {
        Intent intent = new Intent(context, RouteMapActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
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


    @Override
    protected void onDestroy() {
        super.onDestroy();
        this.presenter.detachView();
        if (isFinishing()) {
            getShelterApplication().dependencyInjection().closeRouteScope();
        }
        if (receiver != null) {
            unregisterReceiver(receiver);
        }
    }

}
