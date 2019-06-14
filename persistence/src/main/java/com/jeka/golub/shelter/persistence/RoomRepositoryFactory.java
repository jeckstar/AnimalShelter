package com.jeka.golub.shelter.persistence;

import android.content.Context;

import com.jeka.golub.shelter.domain.repositories.AnimalRepository;
import com.jeka.golub.shelter.domain.repositories.ShelterRepository;
import com.jeka.golub.shelter.persistence.converters.AnimalEntityConverter;
import com.jeka.golub.shelter.persistence.converters.ShelterEntityConverter;
import com.jeka.golub.shelter.persistence.shelter_database.ShelterDatabase;

public class RoomRepositoryFactory implements RepositoryAbstractFactory {

    private final Context context;

    public RoomRepositoryFactory(Context context) {
        this.context = context;
    }

    @Override
    public ShelterRepository getShelterRepository() {
        return new SQLiteShelterRepository(ShelterDatabase.createDatabase(context).getShelterDao(), new ShelterEntityConverter());
    }

    @Override
    public AnimalRepository getAnimalRepository() {
        return new SQLiteAnimalRepository(ShelterDatabase.createDatabase(context).getAnimalDao(), new AnimalEntityConverter());
    }
}
