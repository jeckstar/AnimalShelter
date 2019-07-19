package com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc;

import android.view.View;

import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.RouteView;

import javax.inject.Inject;

import androidx.fragment.app.FragmentActivity;

public class RouteViewFactory {

    @Inject
    public RouteViewFactory() {

    }

    public RouteView createView(FragmentActivity activity, View.OnClickListener onRemoveLastAddedMarker, View.OnClickListener onRemoveAllMarkers) {
        return new RouteView(activity,
                onRemoveLastAddedMarker,
                onRemoveAllMarkers);
    }

}
