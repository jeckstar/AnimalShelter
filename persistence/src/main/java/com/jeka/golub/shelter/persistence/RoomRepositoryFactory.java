package com.jeka.golub.shelter.persistence;

import android.content.Context;

import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;
import com.jeka.golub.shelter.persistence.animal.AnimalEntityConverter;
import com.jeka.golub.shelter.persistence.animal.SQLiteAnimalRepository;
import com.jeka.golub.shelter.persistence.shelter.SQLiteShelterRepository;
import com.jeka.golub.shelter.persistence.shelter.ShelterEntityConverter;

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
