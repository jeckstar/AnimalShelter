package com.jeka.golub.shelter.persistence;

import com.jeka.golub.shelter.persistence.animal.AnimalDao;
import com.jeka.golub.shelter.persistence.animal.AnimalEntity;
import com.jeka.golub.shelter.persistence.route.RouteDao;
import com.jeka.golub.shelter.persistence.route.LocationEntity;
import com.jeka.golub.shelter.persistence.shelter.ShelterDao;
import com.jeka.golub.shelter.persistence.shelter.ShelterEntity;
import com.jeka.golub.shelter.persistence.volunteer.VolunteerDao;
import com.jeka.golub.shelter.persistence.volunteer.VolunteerEntity;
import com.jeka.golub.shelter.persistence.walk.WalkDao;
import com.jeka.golub.shelter.persistence.walk.WalkEntity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(
        entities = {
                AnimalEntity.class,
                ShelterEntity.class,
                VolunteerEntity.class,
                WalkEntity.class,
                LocationEntity.class
        }, version = 3)
public abstract class ShelterDatabase extends RoomDatabase {

    public abstract AnimalDao getAnimalDao();

    public abstract ShelterDao getShelterDao();

    public abstract VolunteerDao getVolunteerDao();

    public abstract WalkDao getWalkDao();

    public abstract RouteDao getRouteDao();

}
