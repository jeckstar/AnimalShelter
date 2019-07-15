package com.jeka.golub.shelter.persistence.walk;

import com.jeka.golub.shelter.domain.walk.Walk;

import java.util.Date;

public class WalkEntityConverter {
    public WalkEntity convertForward(Walk subject) {
        return new WalkEntity(
                subject.getAnimalId(),
                subject.getVolunteerId(),
                subject.getWalkTime().getTime()
        );
    }

    public Walk convertReverse(WalkEntity subject) {
        return new Walk(
                subject.getId(),
                subject.getAnimalId(),
                subject.getVolunteerId(),
                new Date(subject.getWalkTime())
        );
    }
}
