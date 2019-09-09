package com.jeka.golub.shelter.domain.volunteer;

import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.walk.Walk;
import com.jeka.golub.shelter.domain.walk.WalkException;

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


    public Walk takeToTheWalk(final Animal animal, Date now) {
        if (animal.getLastWalkTime() == Animal.DEFAULT_LAST_WALK_TIME ||
                (animal.getLastWalkTime().getTime()
                        + hourToMillisecond(animal.getWalkPeriod())
                        + hourToMillisecond(animal.getWalkPeriod())) < (now.getTime())
        ) {
            final Animal walkingAnimal = animal.setLastWalkTime(now);
            return new Walk(walkingAnimal, this);
        } else {
            throw new WalkException("It is not time to walk yet.");
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

    private long hourToMillisecond(int walkPeriod) {
        return walkPeriod * 60 * 60 * 1000;
    }

}
