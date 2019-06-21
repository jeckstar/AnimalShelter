package com.jeka.golub.shelter.persistence.shelter;

import com.jeka.golub.shelter.domain.shelter.Shelter;


public class ShelterEntityConverter {
    public ShelterEntity convertForward(Shelter subject) {
        return new ShelterEntity(
                subject.getTitle(),
                subject.getAddress(),
                subject.getPhoneNumber());
    }

    public ShelterEntity convertForward(Shelter subject, long shelterId) {
        return null;
    }

    public Shelter convertReverse(ShelterEntity subject) {
        return new Shelter(
                subject.getId(),
                subject.getTitle(),
                subject.getAddress(),
                subject.getPhoneNumber(),
                null);
    }

}
