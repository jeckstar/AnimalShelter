package com.example.android.animalshelter.view.home.shelter_list.choose_shelter.presenter;

import android.os.Handler;
import android.os.Looper;

import com.example.android.animalshelter.view.home.shelter_list.choose_shelter.view.IChoosingShelterView;
import com.jeka.golub.shelter.domain.shelter.Shelter;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

import java.util.List;
import java.util.concurrent.Executor;

public class ChoosingShelterPresenter implements IChoosingShelterPresenter {

    private final ShelterRepository shelterRepositories;
    private final Executor executor;
    private IChoosingShelterView view;

    public ChoosingShelterPresenter(ShelterRepository shelterRepositories, Executor executor) {
        this.shelterRepositories = shelterRepositories;
        this.executor = executor;
    }

    @Override
    public void onShowAllShelters() {
        executor.execute(() -> {
            final List<Shelter> shelters = shelterRepositories.getAll();
            new Handler(Looper.getMainLooper()).post(() -> view.updateShelterList(shelters));
        });
    }

    @Override
    public void attachView(IChoosingShelterView view) {
        this.view = view;
        onShowAllShelters();
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
