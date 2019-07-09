package com.jeka.golub.shelter.domain.volunteer;

import com.jeka.golub.shelter.domain.animal.Animal;

import java.util.Date;

public class Volunteer {

    private final long id;
    private final String firstName;
    private final String lastName;

    public Volunteer(
            String firstName,
            String lastName
    ) {
        this.id = 0L;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public Volunteer(
            long id,
            String firstName,
            String lastName
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }


    public void takeToTheWalk(final Animal animal) {
        final Date nextWalkTime = new Date(animal.getLastWalkTime().getTime() + animal.getWalkPeriod());
        if (new Date().after(nextWalkTime)) {

        } else {
//            throw new WalkException("It is not time to walk yet");
        }
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
