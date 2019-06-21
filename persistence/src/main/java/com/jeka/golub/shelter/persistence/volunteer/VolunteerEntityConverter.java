package com.jeka.golub.shelter.persistence.volunteer;

import com.jeka.golub.shelter.domain.volunteer.Volunteer;

public class VolunteerEntityConverter {

    public VolunteerEntity convertForward(Volunteer subject) {
        return new VolunteerEntity(
                subject.getFirstName(),
                subject.getLastName());
    }

    public VolunteerEntity convertForward(Volunteer subject, long shelterId) {
        return null;
    }

    public Volunteer convertReverse(VolunteerEntity subject) {
        return new Volunteer(
                subject.getId(),
                subject.getFirstName(),
                subject.getLastName());
    }
}
