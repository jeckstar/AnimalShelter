package com.jeka.golub.shelter.persistence.converters;

import android.util.Log;

import com.jeka.golub.shelter.domain.Animal;
import com.jeka.golub.shelter.persistence.shelter_database.entity.AnimalEntity;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class AnimalEntityConverter implements Converter<AnimalEntity, Animal> {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

    @Override
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

    @Override
    public AnimalEntity convertForward(Animal subject, long shelterId) {
        return new AnimalEntity(0L,
                subject.getKind(),
                subject.getName(),
                subject.getAge(),
                subject.getSex(),
                shelterId,
                DATE_FORMAT.format(subject.getLastWalkTime()),
                subject.getWalkPeriod()
        );
    }

    @Override
    public Animal convertReverse(AnimalEntity subject) {
        try {
            return new Animal(subject.getId(),
                    subject.getKind(),
                    subject.getName(),
                    subject.getAge(),
                    subject.getSex(),
                    DATE_FORMAT.parse(subject.getWalkTime()),
                    subject.getWalkPeriod());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return new Animal(subject.getId(),
                subject.getKind(),
                subject.getName(),
                subject.getAge(),
                subject.getSex(),
                new Date(1000),
                subject.getWalkPeriod());
    }
}
