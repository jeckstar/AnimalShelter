package com.jeka.golub.shelter.persistence.animal;

import com.jeka.golub.shelter.domain.animal.Animal;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import static com.jeka.golub.shelter.domain.animal.Animal.DEFAULT_LAST_WALK_TIME;
import static com.jeka.golub.shelter.domain.animal.Animal.NOT_WALKED_YET;

public class AnimalEntityConverter {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

    public AnimalEntity convertForward(Animal subject) {
        return new AnimalEntity(subject.getId(),
                subject.getKind(),
                subject.getName(),
                subject.getAge(),
                subject.getSex(),
                0L,
                DATE_FORMAT.format(subject.getLastWalkTime()),
                subject.getWalkPeriod()
        );
    }

    public AnimalEntity convertForward(Animal subject, long shelterId) {
        String lastWalkTime = subject.getLastWalkTime() == DEFAULT_LAST_WALK_TIME ? NOT_WALKED_YET : DATE_FORMAT.format(subject.getLastWalkTime());
        return new AnimalEntity(0L,
                subject.getKind(),
                subject.getName(),
                subject.getAge(),
                subject.getSex(),
                shelterId,
                lastWalkTime,
                subject.getWalkPeriod()
        );
    }

    public Animal convertReverse(AnimalEntity subject) {
        try {
            Date lastWalkTime = subject.getWalkTime().equals(NOT_WALKED_YET) ? DEFAULT_LAST_WALK_TIME : DATE_FORMAT.parse(subject.getWalkTime());
            return new Animal(subject.getId(),
                    subject.getKind(),
                    subject.getName(),
                    subject.getAge(),
                    subject.getSex(),
                    lastWalkTime,
                    subject.getWalkPeriod());
        } catch (ParseException e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }
}
