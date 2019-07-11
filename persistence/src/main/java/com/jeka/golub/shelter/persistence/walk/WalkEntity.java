package com.jeka.golub.shelter.persistence.walk;

import com.jeka.golub.shelter.persistence.animal.AnimalEntity;
import com.jeka.golub.shelter.persistence.volunteer.VolunteerEntity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static com.jeka.golub.shelter.persistence.walk.WalkEntity.TABLE_NAME;

@Entity(tableName = TABLE_NAME,
        foreignKeys =
                {
                        @ForeignKey(
                                entity = AnimalEntity.class,
                                parentColumns = {AnimalEntity.ID},
                                childColumns = {WalkEntity.ANIMAL_ID}
                        ),
                        @ForeignKey(
                                entity = VolunteerEntity.class,
                                parentColumns = {VolunteerEntity.ID},
                                childColumns = {WalkEntity.VOLUNTEER_ID}
                        ),
                })
public class WalkEntity {

    public static final String TABLE_NAME = "walk_status";
    public static final String ID = "id";
    public static final String ANIMAL_ID = "kind";
    public static final String VOLUNTEER_ID = "volunteer_id";
    public static final String WALK_TIME = "walk_time";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    private final long id;
    @ColumnInfo(name = ANIMAL_ID)
    private final long animalId;
    @ColumnInfo(name = VOLUNTEER_ID)
    private final long volunteerId;
    @ColumnInfo(name = WALK_TIME)
    private final String walkTime;

    public WalkEntity(long id, long animalId, long volunteerId, String walkTime) {
        this.id = id;
        this.animalId = animalId;
        this.volunteerId = volunteerId;
        this.walkTime = walkTime;
    }

    @Ignore
    public WalkEntity(long animalId, long volunteerId, String walkTime) {
        this(0L, animalId, volunteerId, walkTime);
    }

    public long getId() {
        return id;
    }

    public long getAnimalId() {
        return animalId;
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public String getWalkTime() {
        return walkTime;
    }
}
