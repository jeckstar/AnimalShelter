package com.jeka.golub.shelter.domain;

import java.util.Date;

public class Animal {

    private final String name;
    private final Date lastWalkTime;
    private final long period;

    public Animal(String name, Date lastWalkTime, long period) {
        this.name = name;
        this.lastWalkTime = lastWalkTime;
        this.period = period;
    }

    public String getName() {
        return name;
    }

    public Date getLastWalkTime() {
        return lastWalkTime;
    }

    public long getPeriod() {
        return period;
    }
}
