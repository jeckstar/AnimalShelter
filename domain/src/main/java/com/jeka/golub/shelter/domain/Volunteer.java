package com.jeka.golub.shelter.domain;

import java.util.Date;

public class Volunteer {

    private final String name;
    private final WalkRepository walkRepository;

    public Volunteer(String name, WalkRepository walkRepository) {
        this.name = name;
        this.walkRepository = walkRepository;
    }

    public void takeToTheWalk(final Animal animal) {
        final Date nextWalkTime = new Date(animal.getLastWalkTime().getTime() + animal.getPeriod());
        if (new Date().after(nextWalkTime)) {
            //гуляем
            walkRepository.takeAnimalForWalk(this, animal);
        } else {
            throw new WalkException("It is not time to walk yet");
        }
    }

    public String getName() {
        return name;
    }
}
