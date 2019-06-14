package com.jeka.golub.shelter.persistence;

import android.content.Context;

import com.jeka.golub.shelter.persistence.animal.AnimalDao;
import com.jeka.golub.shelter.persistence.shelter.ShelterDao;
import com.jeka.golub.shelter.persistence.volunteer.VolunteerDao;
import com.jeka.golub.shelter.persistence.walk.WalkDao;
import com.jeka.golub.shelter.persistence.animal.AnimalEntity;
import com.jeka.golub.shelter.persistence.shelter.ShelterEntity;
import com.jeka.golub.shelter.persistence.volunteer.VolunteerEntity;
import com.jeka.golub.shelter.persistence.walk.WalkEntity;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(
        entities = {
                AnimalEntity.class,
                ShelterEntity.class,
                VolunteerEntity.class,
                WalkEntity.class
        }, version = 1)
public abstract class ShelterDatabase extends RoomDatabase {

    private static ShelterDatabase instance;

    protected ShelterDatabase() {
    }

    private static final String FILE_NAME = "shelter.db";

    public abstract AnimalDao getAnimalDao();

    public abstract ShelterDao getShelterDao();

    public abstract VolunteerDao getVolunteerDao();

    public abstract WalkDao getWalkDao();

    public static synchronized ShelterDatabase createDatabase(final Context context) {
        if (instance == null) {
            return Room.databaseBuilder(context, ShelterDatabase.class, FILE_NAME).build();
        }
        return instance;
    }
}
