package com.jeka.golub.shelter.persistence.walk;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static com.jeka.golub.shelter.persistence.walk.WalkEntity.ANIMAL_ID;
import static com.jeka.golub.shelter.persistence.walk.WalkEntity.SHELTER_ID;
import static com.jeka.golub.shelter.persistence.walk.WalkEntity.TABLE_NAME;

@Entity(tableName = TABLE_NAME, indices = {@Index(value = {ANIMAL_ID, SHELTER_ID}, unique = true)})
public class WalkEntity {

    public static final String TABLE_NAME = "walk_status";
    public static final String ID = "id";
    public static final String ANIMAL_ID = "kind";
    public static final String SHELTER_ID = "shelter_id";
    public static final String WALK_TIME = "walk_time";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    private final long id;
    @ColumnInfo(name = ANIMAL_ID)
    private final long animalId;
    @ColumnInfo(name = SHELTER_ID)
    private final long shelterId;
    @ColumnInfo(name = WALK_TIME)
    private final long walkTime;

    public WalkEntity(long id, long animalId, long shelterId, long walkTime) {
        this.id = id;
        this.animalId = animalId;
        this.shelterId = shelterId;
        this.walkTime = walkTime;
    }

    @Ignore
    public WalkEntity(long animalId, long shelterId, long walkTime) {
        this.id = 0L;
        this.animalId = animalId;
        this.shelterId = shelterId;
        this.walkTime = walkTime;
    }

    public long getId() {
        return id;
    }

    public long getAnimalId() {
        return animalId;
    }

    public long getShelterId() {
        return shelterId;
    }

    public long getWalkTime() {
        return walkTime;
    }
}