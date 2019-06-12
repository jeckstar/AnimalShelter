package com.jeka.golub.shelter.domain;

import com.jeka.golub.shelter.domain.repositories.WalkRepository;

import java.util.Date;

public class Volunteer {

    private final WalkRepository walkRepository;

    private final long id;
    private final String firstName;
    private final String lastName;

    public Volunteer(
            WalkRepository walkRepository,
            long id,
            String firstName,
            String lastName
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.walkRepository = walkRepository;
    }

    public Volunteer(
                     long id,
                     String firstName,
                     String lastName
    ) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.walkRepository = null;
    }

    public Volunteer(WalkRepository walkRepository,
                     String firstName,
                     String lastName
    ) {
        this.id = 0L;
        this.firstName = firstName;
        this.lastName = lastName;
        this.walkRepository = walkRepository;
    }


    public void takeToTheWalk(final Animal animal) {
        final Date nextWalkTime = new Date(animal.getLastWalkTime().getTime() + animal.getWalkPeriod());
        if (new Date().after(nextWalkTime)) {
            //гуляем
            walkRepository.takeAnimalForWalk(this, animal);
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
