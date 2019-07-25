package com.jeka.golub.shelter.persistence.route;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.route.LocationEntity.TABLE_NAME;


@Dao
public interface RouteDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<LocationEntity> getAll();

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE walk_id = :walkId  ORDER BY walk_id")
    List<LocationEntity> getRouteByWalkId(long walkId);

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    LocationEntity getById(long id);

    @Insert
    void insert(LocationEntity routeEntity);

    @Update
    void update(LocationEntity routeEntity);

    @Delete
    void delete(LocationEntity routeEntity);
}
