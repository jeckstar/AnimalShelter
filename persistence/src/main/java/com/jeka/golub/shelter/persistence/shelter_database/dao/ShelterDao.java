package com.jeka.golub.shelter.persistence.shelter_database.dao;

import com.jeka.golub.shelter.persistence.shelter_database.entity.ShelterEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.shelter_database.entity.ShelterEntity.TABLE_NAME;

@Dao
public interface ShelterDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<ShelterEntity> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    ShelterEntity getById(long id);

    @Insert
    void insert(ShelterEntity animal);

    @Update
    void update(ShelterEntity animal);

    @Delete
    void delete(ShelterEntity animal);
}
