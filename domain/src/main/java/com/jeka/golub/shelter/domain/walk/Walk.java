package com.jeka.golub.shelter.domain.walk;

import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

public class Walk {

    private final long id;
    private final long animalId;
    private final long volunteerId;
    private final long walkTime;
    private Animal animal;
    private Volunteer volunteer;

    public Walk(long id, long animalId, long volunteerId, long walkTime) {
        this.id = id;
        this.animalId = animalId;
        this.volunteerId = volunteerId;
        this.walkTime = walkTime;
    }

    public Walk(long animalId, long volunteerId, long walkTime) {
        this.id = 0L;
        this.animalId = animalId;
        this.volunteerId = volunteerId;
        this.walkTime = walkTime;
    }

    public Walk(Animal animal, Volunteer volunteer) {
        this.id = 0L;
        this.animal = animal;
        this.volunteer = volunteer;
        this.animalId = animal.getId();
        this.volunteerId = volunteer.getId();
        this.walkTime = animal.getWalkPeriod();
    }

    public long getId() {
        return id;
    }

    public long getAnimalId() {
        return animalId;
    }

    public long getVolunteerId() {
        return volunteerId;
    }

    public long getWalkTime() {
        return walkTime;
    }

    public Animal getAnimal() {
        if (animal != null) {
            return animal;
        } else {
            throw new NullPointerException();
        }
    }

    public Volunteer getVolunteer() {
        if (volunteer != null) {
            return volunteer;
        } else {
            throw new NullPointerException();
        }    }
}
