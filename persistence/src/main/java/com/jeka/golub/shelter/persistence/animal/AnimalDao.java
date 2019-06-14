package com.jeka.golub.shelter.persistence.animal;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.animal.AnimalEntity.TABLE_NAME;

@Dao
public interface AnimalDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<AnimalEntity> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE shelter_id = :id")
    List<AnimalEntity> getAllByShelterId(long id);

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    AnimalEntity getById(long id);

    @Insert
    void insert(AnimalEntity animal);

    @Update
    void update(AnimalEntity animal);

    @Delete
    void delete(AnimalEntity animal);

}
