package com.jeka.golub.shelter.domain;

import java.util.Date;

public class Animal {

    private final long id;
    private final String kind;
    private final String name;
    private final int sex;
    private final String age;
    private final long shelterId;
    private final Date lastWalkTime;
    private final long walkPeriod;

    public Animal(
            long id,
            String kind,
            String name,
            String age,
            int sex,
            long shelterId,
            Date lastWalkTime,
            long walkPeriod
    ) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.age = age;
        this.sex = sex;
        this.shelterId = shelterId;
        this.lastWalkTime = lastWalkTime;
        this.walkPeriod = walkPeriod;
    }

    public Animal(
            String kind,
            String name,
            String age,
            int sex,
            long shelterId,
            long walkPeriod
            ) {
        this.id = 0L;
        this.kind = kind;
        this.name = name;
        this.sex = sex;
        this.lastWalkTime = null;
        this.age = age;
        this.shelterId = shelterId;
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

    public String getAge() {
        return age;
    }

    public long getShelterId() {
        return shelterId;
    }

    public long getWalkPeriod() {
        return walkPeriod;
    }
}
