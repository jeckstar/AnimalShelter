package com.example.android.animalshelter.view.home.create_volunteer.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.create_volunteer.view.CreateVolunteerCardView;
import com.example.android.animalshelter.view.home.create_volunteer.view.ICreateVolunteerCardView;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class CreateVolunteerCardPresenter implements ICreateVolunteerCardPresenter {
    private final ICreateVolunteerCardView view;
    private final VolunteerRepository volunteerRepositories;
    private final Executor executor;


    public CreateVolunteerCardPresenter(CreateVolunteerCardView view, VolunteerRepository volunteerRepositories, Executor executor) {
        this.view = view;
        this.volunteerRepositories = volunteerRepositories;
        this.executor = executor;
    }


    @Override
    public void onShowAllVolunteers(){
        executor.execute(() -> {
            final List<Volunteer> all = volunteerRepositories.getAll();
            String vList = " ";
            for (Volunteer v: all) {
                vList += v.getFirstName() + v.getLastName()+ "\n";
            }
            String finalVList = vList;
            new Handler(Looper.getMainLooper()).post(() -> view.showVolunteers(finalVList));
        });
    }

    @Override
    public void onSaveCardClicked(String firstName, String secondName) {
        executor.execute(() -> {
            Volunteer volunteer = new Volunteer(firstName,secondName);
            volunteerRepositories.add(volunteer);
            new Handler(Looper.getMainLooper()).post(view::showThatVolunteerWasCreatedSuccessfully);
        });
    }
}
