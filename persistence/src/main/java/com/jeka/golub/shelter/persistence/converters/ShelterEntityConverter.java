package com.jeka.golub.shelter.persistence.converters;

import com.jeka.golub.shelter.domain.Shelter;
import com.jeka.golub.shelter.persistence.shelter_database.entity.ShelterEntity;


public class ShelterEntityConverter implements Converter<ShelterEntity, Shelter> {
    @Override
    public ShelterEntity convertForward(Shelter subject) {
        return new ShelterEntity(
                subject.getTitle(),
                subject.getAddress(),
                subject.getPhoneNumber());
    }

    @Override
    public ShelterEntity convertForward(Shelter subject, long shelterId) {
        return null;
    }

    @Override
    public Shelter convertReverse(ShelterEntity subject) {
        return new Shelter(
                subject.getId(),
                subject.getTitle(),
                subject.getAddress(),
                subject.getPhoneNumber(),
                null);
    }

}
