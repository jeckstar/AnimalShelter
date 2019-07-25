package com.jeka.golub.shelter.persistence.walk;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.walk.WalkEntity.TABLE_NAME;

@Dao
public interface WalkDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<WalkEntity> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    WalkEntity getById(long id);

    @Query("SELECT id FROM " + TABLE_NAME + " WHERE animal_Id = :animalId AND volunteer_id = :volunteerId AND walk_time = :walkTime")
    long getId(long animalId, long volunteerId, long walkTime);

    @Insert
    void insert(WalkEntity animal);

    @Update
    void update(WalkEntity animal);

    @Delete
    void delete(WalkEntity animal);
}
