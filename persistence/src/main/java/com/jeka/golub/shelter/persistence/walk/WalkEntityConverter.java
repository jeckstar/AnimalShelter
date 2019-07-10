package com.jeka.golub.shelter.persistence.walk;

import com.jeka.golub.shelter.domain.walk.Walk;

public class WalkEntityConverter {
    public WalkEntity convertForward(Walk subject) {
        return new WalkEntity(
                subject.getAnimalId(),
                subject.getVolunteerId(),
                subject.getWalkTime()
        );
    }

    public WalkEntity convertForward(Walk subject, long shelterId) {
        return null;
    }

    public Walk convertReverse(WalkEntity subject) {
        return new Walk(
                subject.getId(),
                subject.getAnimalId(),
                subject.getVolunteerId(),
                subject.getWalkTime()
        );
    }
}
