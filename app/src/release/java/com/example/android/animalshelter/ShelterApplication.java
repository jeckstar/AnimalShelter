package com.example.android.animalshelter;

import android.app.Application;

import com.jeka.golub.shelter.persistence.RepositoryAbstractFactory;
import com.jeka.golub.shelter.persistence.RoomRepositoryFactory;

public class ShelterApplication extends Application {

    private RepositoryAbstractFactory repositoryAbstractFactory;

    @Override
    public void onCreate() {
        super.onCreate();
        repositoryAbstractFactory = new RoomRepositoryFactory(this);
    }

    public RepositoryAbstractFactory getRepositoryFactory() {
        return repositoryAbstractFactory;
    }
}
