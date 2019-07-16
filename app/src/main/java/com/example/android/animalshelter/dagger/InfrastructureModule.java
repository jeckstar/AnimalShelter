package com.example.android.animalshelter.dagger;

import android.content.Context;

import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;
import com.jeka.golub.shelter.domain.walk.WalkRepository;
import com.jeka.golub.shelter.persistence.ShelterDatabase;
import com.jeka.golub.shelter.persistence.animal.AnimalEntityConverter;
import com.jeka.golub.shelter.persistence.animal.SQLiteAnimalRepository;
import com.jeka.golub.shelter.persistence.migration.DatabaseMigration;
import com.jeka.golub.shelter.persistence.shelter.SQLiteShelterRepository;
import com.jeka.golub.shelter.persistence.shelter.ShelterEntityConverter;
import com.jeka.golub.shelter.persistence.volunteer.SQLiteVolunteerRepository;
import com.jeka.golub.shelter.persistence.volunteer.VolunteerEntityConverter;
import com.jeka.golub.shelter.persistence.walk.SQLiteWalkRepository;
import com.jeka.golub.shelter.persistence.walk.WalkEntityConverter;

import javax.inject.Singleton;

import androidx.room.Room;
import dagger.Module;
import dagger.Provides;

@Module
public class InfrastructureModule {

    private static final String FILE_NAME = "shelter.db";

    @Singleton
    @Provides
    public ShelterDatabase shelterDatabase(Context context) {
        synchronized (ShelterDatabase.class) {
            return Room.databaseBuilder(context, ShelterDatabase.class, FILE_NAME)
                    .addMigrations(DatabaseMigration.MIGRATION_1_2)
                    .build();
        }
    }

    @Singleton
    @Provides
    public AnimalRepository animalRepository(ShelterDatabase database) {
        return new SQLiteAnimalRepository(database.getAnimalDao(), new AnimalEntityConverter());
    }

    @Singleton
    @Provides
    public ShelterRepository shelterRepository(ShelterDatabase database) {
        return new SQLiteShelterRepository(database.getShelterDao(), new ShelterEntityConverter());
    }

    @Singleton
    @Provides
    public VolunteerRepository volunteerRepository(ShelterDatabase database) {
        return new SQLiteVolunteerRepository(database.getVolunteerDao(), new VolunteerEntityConverter());
    }

    @Singleton
    @Provides
    public WalkRepository walkRepository(ShelterDatabase database) {
        return new SQLiteWalkRepository(database.getWalkDao(), new WalkEntityConverter());
    }

}
