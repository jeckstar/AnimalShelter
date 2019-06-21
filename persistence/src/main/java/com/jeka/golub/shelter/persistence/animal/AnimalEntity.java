package com.jeka.golub.shelter.persistence.animal;


import com.jeka.golub.shelter.persistence.shelter.ShelterEntity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.ForeignKey;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static com.jeka.golub.shelter.persistence.animal.AnimalEntity.TABLE_NAME;

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
    private final int age;
    @ColumnInfo(name = SEX)
    private final int sex;
    @ColumnInfo(name = SHELTER_ID)
    private final long shelterId;
    @ColumnInfo(name = WALK_TIME)
    private final String walkTime;
    @ColumnInfo(name = WALK_PERIOD)
    private final int walkPeriod;

    public AnimalEntity(
            long id,
            String kind,
            String name,
            int age,
            int sex,
            long shelterId,
            String walkTime,
            int walkPeriod
    ) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.shelterId = shelterId;
        this.walkTime = walkTime;
        this.walkPeriod = walkPeriod;
    }

    @Ignore
    public AnimalEntity(
            String kind,
            String name,
            int age,
            int sex,
            long shelterId,
            String walkTime,
            int walkPeriod
    ) {
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

    public int getAge() {
        return age;
    }

    public int getSex() {
        return sex;
    }

    public long getShelterId() {
        return shelterId;
    }

    public String getWalkTime() {
        return walkTime;
    }

    public int getWalkPeriod() {
        return walkPeriod;
    }
}
