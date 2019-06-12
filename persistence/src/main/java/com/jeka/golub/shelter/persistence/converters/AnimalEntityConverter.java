package com.jeka.golub.shelter.persistence.converters;

import com.jeka.golub.shelter.domain.Animal;
import com.jeka.golub.shelter.persistence.shelter_database.entity.AnimalEntity;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

public class AnimalEntityConverter implements Converter<AnimalEntity, Animal> {

    public static final SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy.MM.dd G 'at' HH:mm:ss z");

    @Override
    public AnimalEntity convertForward(Animal subject) {
        final DateFormat dateFormat = DATE_FORMAT;
        return new AnimalEntity(subject.getId(),
                subject.getKind(),
                subject.getName(),
                subject.getAge(),
                subject.getSex(),
                subject.getShelterId(),
                dateFormat.format(subject.getLastWalkTime()),
                subject.getWalkPeriod());
    }

    @Override
    public Animal convertReverse(AnimalEntity subject){
        final DateFormat dateFormat = DATE_FORMAT;
        try {
            return new Animal(subject.getId(),
                    subject.getKind(),
                    subject.getName(),
                    subject.getAge(),
                    subject.getSex(),
                    subject.getShelterId(),
                    dateFormat.parse(subject.getWalkTime()),
                    subject.getWalkCount());
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
}
