package com.jeka.golub.shelter.persistence.volunteer;

import com.jeka.golub.shelter.persistence.animal.AnimalEntity;
import com.jeka.golub.shelter.persistence.walk.WalkEntity;

import java.util.List;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import static com.jeka.golub.shelter.persistence.volunteer.VolunteerEntity.TABLE_NAME;

@Dao
public interface VolunteerDao {

    @Query("SELECT * FROM " + TABLE_NAME)
    List<VolunteerEntity> getAll();

    @Query(
            "SELECT " + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.ID + ", "
                    + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.FIRST_NAME + ", "
                    + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.LAST_NAME +
                    " FROM " + VolunteerEntity.TABLE_NAME +
                    " JOIN " + WalkEntity.TABLE_NAME +
                    " ON " + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.ID + " = " + WalkEntity.TABLE_NAME + "." + WalkEntity.VOLUNTEER_ID +
                    " JOIN " + AnimalEntity.TABLE_NAME +
                    " ON " + WalkEntity.TABLE_NAME + "." + WalkEntity.ANIMAL_ID + " = " + AnimalEntity.TABLE_NAME + "." + AnimalEntity.ID +
                    " GROUP BY " + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.ID +
                    " HAVING MAX(" + WalkEntity.TABLE_NAME + "." + WalkEntity.WALK_TIME + ") + " + AnimalEntity.TABLE_NAME + "." + AnimalEntity.WALK_PERIOD +
                    " * 60 * 60 * 1000 " +
                    " < :currentTime" +
                    " UNION ALL" +
                    " SELECT " + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.ID + ", "
                    + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.FIRST_NAME + ", "
                    + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.LAST_NAME +
                    " FROM " + VolunteerEntity.TABLE_NAME +
                    " WHERE " + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.ID +
                    " NOT IN(SELECT " + WalkEntity.VOLUNTEER_ID + " FROM " + WalkEntity.TABLE_NAME + ")" +
                    " GROUP BY " + VolunteerEntity.TABLE_NAME + "." + VolunteerEntity.ID
    )
    List<VolunteerEntity> getAvailable(long currentTime);

    @Query("SELECT * FROM " + TABLE_NAME + " WHERE id = :id")
    VolunteerEntity getById(long id);

    @Insert
    void insert(VolunteerEntity animal);

    @Update
    void update(VolunteerEntity animal);

    @Delete
    void delete(VolunteerEntity animal);
}
