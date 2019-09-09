package com.jeka.golub.shelter.domain.animal;

import java.util.Date;

public class Animal {

    private final long id;
    private final String kind;
    private final String name;
    private final int sex;
    private final int age;
    private final int walkPeriod;
    private Date lastWalkTime;

    public static final Date DEFAULT_LAST_WALK_TIME = new Date(1000);
    public static final long NOT_WALKED_YET = 1000;


    public Animal(
            long id,
            String kind,
            String name,
            int age,
            int sex,
            Date lastWalkTime,
            int walkPeriod
    ) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.lastWalkTime = lastWalkTime;
        this.walkPeriod = walkPeriod;
    }

    public Animal(
            String kind,
            String name,
            int age,
            int sex,
            int walkPeriod
    ) {
        this(0, kind, name, age, sex, DEFAULT_LAST_WALK_TIME, walkPeriod);
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

    public int getSex() {
        return sex;
    }

    public Date getLastWalkTime() {
        return lastWalkTime;
    }

    public Animal setLastWalkTime(Date lastWalkTime) {
        this.lastWalkTime = lastWalkTime;
        return new Animal(this.id,
                this.kind,
                this.name,
                this.age,
                this.sex,
                lastWalkTime,
                this.walkPeriod
        );
    }

    public int getAge() {
        return age;
    }

    public int getWalkPeriod() {
        return walkPeriod;
    }
}
