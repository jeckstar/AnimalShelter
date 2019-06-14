package com.jeka.golub.shelter.persistence.converters;

import com.jeka.golub.shelter.domain.Volunteer;
import com.jeka.golub.shelter.persistence.shelter_database.entity.VolunteerEntity;

public class VolunteerEntityConverter implements Converter<VolunteerEntity, Volunteer> {

    @Override
    public VolunteerEntity convertForward(Volunteer subject) {
        return new VolunteerEntity(
                subject.getFirstName(),
                subject.getLastName());
    }

    @Override
    public VolunteerEntity convertForward(Volunteer subject, long shelterId) {
        return null;
    }

    @Override
    public Volunteer convertReverse(VolunteerEntity subject) {
        return new Volunteer(
                subject.getId(),
                subject.getFirstName(),
                subject.getLastName());
    }
}
