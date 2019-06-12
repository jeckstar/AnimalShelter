package com.jeka.golub.shelter.persistence;

import android.content.Context;

import com.jeka.golub.shelter.domain.repositories.ShelterRepository;
import com.jeka.golub.shelter.persistence.converters.ShelterEntityConverter;
import com.jeka.golub.shelter.persistence.shelter_database.ShelterDatabase;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class RoomRepositoryFactory implements RepositoryAbstractFactory {

    private static final ExecutorService REPOSITORY_SHARED_EXECUTOR = Executors.newCachedThreadPool();
    private final Context context;

    public RoomRepositoryFactory(Context context) {
        this.context = context;
    }

    @Override
    public ShelterRepository getShelterRepository() {
        return new SQLiteShelterRepository(ShelterDatabase.createDatabase(context).getShelterDao(), new ShelterEntityConverter(), REPOSITORY_SHARED_EXECUTOR);
    }
}
