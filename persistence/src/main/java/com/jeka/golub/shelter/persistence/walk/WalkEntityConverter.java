package com.jeka.golub.shelter.persistence.walk;

import com.jeka.golub.shelter.domain.walk.Walk;

import java.text.ParseException;

import static com.jeka.golub.shelter.persistence.animal.AnimalEntityConverter.DATE_FORMAT;

public class WalkEntityConverter {
    public WalkEntity convertForward(Walk subject) {
        return new WalkEntity(
                subject.getAnimalId(),
                subject.getVolunteerId(),
                DATE_FORMAT.format(subject.getWalkTime())
        );
    }

    public Walk convertReverse(WalkEntity subject) {
        try {
            return new Walk(
                    subject.getId(),
                    subject.getAnimalId(),
                    subject.getVolunteerId(),
                    DATE_FORMAT.parse(subject.getWalkTime())
            );
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
