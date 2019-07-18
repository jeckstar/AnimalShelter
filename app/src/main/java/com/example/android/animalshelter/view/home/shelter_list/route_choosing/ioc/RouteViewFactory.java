package com.example.android.animalshelter.view.home.shelter_list.route_choosing.ioc;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.example.android.animalshelter.utils.IOnItemClickListener;
import com.example.android.animalshelter.view.home.shelter_list.animal_card_menu.view.AnimalCardView;
import com.example.android.animalshelter.view.home.shelter_list.route_choosing.view.RouteView;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

import javax.inject.Inject;

import androidx.annotation.NonNull;
import androidx.fragment.app.FragmentActivity;

public class RouteViewFactory {

    @Inject
    public RouteViewFactory() {

    }

    public RouteView createView(FragmentActivity activity) {
        return new RouteView(activity);
    }

}
