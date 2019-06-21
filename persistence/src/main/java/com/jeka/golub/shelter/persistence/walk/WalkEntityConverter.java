package com.jeka.golub.shelter.persistence.walk;

import com.jeka.golub.shelter.domain.walk.WalkingAnimal;

public class WalkEntityConverter {
    public WalkEntity convertForward(WalkingAnimal subject) {
        return new WalkEntity(
                subject.getAnimalId(),
                subject.getShelterId(),
                subject.getWalkTime()
        );
    }

    public WalkEntity convertForward(WalkingAnimal subject, long shelterId) {
        return null;
    }

    public WalkingAnimal convertReverse(WalkEntity subject) {
        return new WalkingAnimal(
                subject.getId(),
                subject.getAnimalId(),
                subject.getShelterId(),
                subject.getWalkTime()
        );
    }
}
