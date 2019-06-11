package com.jeka.golub.shelter.persistence.shelter_database;

import android.content.Context;

import com.jeka.golub.shelter.persistence.shelter_database.dao.AnimalDao;
import com.jeka.golub.shelter.persistence.shelter_database.dao.ShelterDao;
import com.jeka.golub.shelter.persistence.shelter_database.dao.VolunteerDao;
import com.jeka.golub.shelter.persistence.shelter_database.dao.WalkDao;
import com.jeka.golub.shelter.persistence.shelter_database.entity.AnimalEntity;
import com.jeka.golub.shelter.persistence.shelter_database.entity.ShelterEntity;
import com.jeka.golub.shelter.persistence.shelter_database.entity.VolunteerEntity;
import com.jeka.golub.shelter.persistence.shelter_database.entity.WalkEntity;

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

    private ShelterDatabase() {
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
