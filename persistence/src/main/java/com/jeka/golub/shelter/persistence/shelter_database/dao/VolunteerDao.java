package com.jeka.golub.shelter.persistence.shelter_database.dao;

import com.jeka.golub.shelter.persistence.shelter_database.entity.VolunteerEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.shelter_database.entity.VolunteerEntity.TABLE_NAME;

@Dao
public interface VolunteerDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<VolunteerEntity> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    VolunteerEntity getById(long id);

    @Insert
    void insert(VolunteerEntity animal);

    @Update
    void update(VolunteerEntity animal);

    @Delete
    void delete(VolunteerEntity animal);
}
