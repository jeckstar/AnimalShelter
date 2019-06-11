package com.jeka.golub.shelter.persistence.shelter_database.dao;

import com.jeka.golub.shelter.persistence.shelter_database.entity.AnimalEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.shelter_database.entity.AnimalEntity.TABLE_NAME;

@Dao
public interface AnimalDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<AnimalEntity> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    AnimalEntity getById(long id);

    @Insert
    void insert(AnimalEntity animal);

    @Update
    void update(AnimalEntity animal);

    @Delete
    void delete(AnimalEntity animal);

}
