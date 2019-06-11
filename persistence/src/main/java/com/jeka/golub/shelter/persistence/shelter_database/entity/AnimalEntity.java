package com.jeka.golub.shelter.persistence.shelter_database.entity;


import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static com.jeka.golub.shelter.persistence.shelter_database.entity.AnimalEntity.TABLE_NAME;

@Entity(tableName = TABLE_NAME,
        foreignKeys = {@ForeignKey(
                entity = ShelterEntity.class,
                parentColumns = ShelterEntity.ID,
                childColumns = AnimalEntity.SHELTER_ID,
                onDelete = ForeignKey.SET_NULL
        )},
        indices = {@Index(value = {AnimalEntity.SHELTER_ID})})
public class AnimalEntity {

    public static final String TABLE_NAME = "animals";
    public static final String ID = "id";
    public static final String KIND = "kind";
    public static final String NAME = "name";
    public static final String AGE = "age";
    public static final String SEX = "sex";
    public static final String SHELTER_ID = "shelter_id";
    public static final String WALK_TIME = "walk_time";
    public static final String WALK_PERIOD = "walk_period";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    private final long id;
    @ColumnInfo(name = KIND)
    private final String kind;
    @ColumnInfo(name = NAME)
    private final String name;
    @ColumnInfo(name = AGE)
    private final String age;
    @ColumnInfo(name = SEX)
    private final String sex;
    @ColumnInfo(name = SHELTER_ID)
    private final long shelterId;
    @ColumnInfo(name = WALK_TIME)
    private final long walkTime;
    @ColumnInfo(name = WALK_PERIOD)
    private final long walkPeriod;

    public AnimalEntity(long id, String kind, String name, String age, String sex, long shelterId, long walkTime, long walkPeriod) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.shelterId = shelterId;
        this.walkTime = walkTime;
        this.walkPeriod = walkPeriod;
    }

    public AnimalEntity(String kind, String name, String age, String sex, long shelterId, long walkTime, long walkPeriod) {
        this.id = 0L;
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.shelterId = shelterId;
        this.walkTime = walkTime;
        this.walkPeriod = walkPeriod;
    }

    public long getId() {
        return id;
    }

    public String getKind() {
        return kind;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public String getSex() {
        return sex;
    }

    public long getShelterId() {
        return shelterId;
    }

    public long getWalkTime() {
        return walkTime;
    }

    public long getWalkCount() {
        return walkPeriod;
    }

}
