package com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.R;
import com.example.android.animalshelter.backbone.ShelterFragment;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.ioc.RouteDisplayViewFactory;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.presenter.IRouteDisplayPresenter;
import com.example.android.animalshelter.view.home.shelter_list.shelter_card_menu.route_display.view.IRouteDisplayView;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;

import javax.inject.Inject;

public class RouteDisplayFragment extends ShelterFragment implements OnMapReadyCallback {

    private static final String WALK_KEY = "walk_key";

    @Inject
    IRouteDisplayPresenter presenter;
    @Inject
    RouteDisplayViewFactory factory;
    private IRouteDisplayView view;
    private GoogleMap map;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (savedInstanceState == null) {
            Bundle bundle = this.getArguments();
            long walkId = bundle.getLong(WALK_KEY);
            getShelterApplication().dependencyInjection().openRouteDisplayScope(walkId);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getShelterApplication().dependencyInjection().inject(this);
        view = factory.createView(
                inflater,
                container,
                savedInstanceState);
        SupportMapFragment mapFragment = (SupportMapFragment) this.getChildFragmentManager()
                .findFragmentById(R.id.route_display_fragment_map);
        mapFragment.getMapAsync(this);
        presenter.onCreate(view);
        return view.getAndroidView();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        this.presenter.detachView();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (getActivity().isFinishing()) {
            getShelterApplication().dependencyInjection().closeRouteDisplayScope();
        }
    }

    @Override
    public void onMapReady(GoogleMap googleMap) {
        map = googleMap;
        view.withMap(map);
    }

    public static RouteDisplayFragment newInstance(long walk) {
        RouteDisplayFragment fragment = new RouteDisplayFragment();
        Bundle args = new Bundle();
        args.putLong(WALK_KEY, walk);
        fragment.setArguments(args);
        return fragment;
    }
}
