package com.jeka.golub.shelter.persistence.converters;

import com.jeka.golub.shelter.domain.WalkingAnimal;
import com.jeka.golub.shelter.persistence.shelter_database.entity.WalkEntity;

public class WalkEntityConverter implements Converter<WalkEntity, WalkingAnimal> {
    @Override
    public WalkEntity convertForward(WalkingAnimal subject) {
        return new WalkEntity(
                subject.getAnimalId(),
                subject.getShelterId(),
                subject.getWalkTime()
        );
    }

    @Override
    public WalkingAnimal convertReverse(WalkEntity subject) {
        return new WalkingAnimal(
                subject.getId(),
                subject.getAnimalId(),
                subject.getShelterId(),
                subject.getWalkTime()
        );
    }
}
