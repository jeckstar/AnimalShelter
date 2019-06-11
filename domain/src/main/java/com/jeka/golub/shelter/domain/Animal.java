package com.jeka.golub.shelter.domain;

import java.util.Date;

public class Animal {

    private final long id;
    private final String kind;
    private final String name;
    private final String sex;
    private final Date lastWalkTime;
    private final long age;
    private final String shelterId;
    private final long walkPeriod;

    public Animal(long id, String kind, String name, String sex, Date lastWalkTime, long age, String shelterId, long walkPeriod) {
        this.id = id;
        this.kind = kind;
        this.name = name;
        this.sex = sex;
        this.lastWalkTime = lastWalkTime;
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

    public String getSex() {
        return sex;
    }

    public Date getLastWalkTime() {
        return lastWalkTime;
    }

    public long getAge() {
        return age;
    }

    public String getShelterId() {
        return shelterId;
    }

    public long getWalkPeriod() {
        return walkPeriod;
    }
}
