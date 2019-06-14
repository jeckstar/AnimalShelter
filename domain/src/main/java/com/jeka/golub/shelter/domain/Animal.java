package com.jeka.golub.shelter.domain;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Animal {

    private final long id;
    private final String kind;
    private final String name;
    private final int sex;
    private final int age;
    private final Date lastWalkTime;
    private final int walkPeriod;
    private final Date ANIMAL_NOW_WALKED_YET = new Date(1000);



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
        this.id = 0L;
        this.kind = kind;
        this.name = name;
        this.sex = sex;
        this.lastWalkTime = ANIMAL_NOW_WALKED_YET;
        this.age = age;
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

    public int getSex() {
        return sex;
    }

    public Date getLastWalkTime() {
        return lastWalkTime;
    }

    public int getAge() {
        return age;
    }

    public int getWalkPeriod() {
        return walkPeriod;
    }
}
