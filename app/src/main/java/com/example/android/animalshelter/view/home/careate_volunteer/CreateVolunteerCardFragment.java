package com.example.android.animalshelter.view.home.careate_volunteer;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.android.animalshelter.ShelterApplication;
import com.example.android.animalshelter.view.home.careate_volunteer.presenter.CreateVolunteerCardPresenter;
import com.example.android.animalshelter.view.home.careate_volunteer.presenter.ICreateVolunteerCardPresenter;
import com.example.android.animalshelter.view.home.careate_volunteer.view.CreateVolunteerCardView;

import java.util.concurrent.Executors;

import androidx.fragment.app.Fragment;

public class CreateVolunteerCardFragment extends Fragment implements CreateVolunteerEventConsumer {

    private ICreateVolunteerCardPresenter presenter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        final CreateVolunteerCardView view = new CreateVolunteerCardView(
                inflater,
                container,
                savedInstanceState,
                this);
        presenter = new CreateVolunteerCardPresenter(
                view,
                ((ShelterApplication) getActivity()
                        .getApplication())
                        .getRepositoryFactory()
                        .getVolunteerRepository(),
                Executors.newCachedThreadPool());
        presenter.onShowAllVolunteers();
        // Inflate the layout for this fragment
        return view.getAndroidView();
    }

    @Override
    public void onSaveClick(String firstName, String secondName) {
        presenter.onSaveCardClicked(firstName, secondName);
    }
}
