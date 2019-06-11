package com.jeka.golub.shelter.persistence.shelter_database.dao;

import com.jeka.golub.shelter.persistence.shelter_database.entity.WalkEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.shelter_database.entity.WalkEntity.TABLE_NAME;

@Dao
public interface WalkDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<WalkEntity> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    WalkEntity getById(long id);

    @Insert
    void insert(WalkEntity animal);

    @Update
    void update(WalkEntity animal);

    @Delete
    void delete(WalkEntity animal);
}
