package com.jeka.golub.shelter.domain.walk;

import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.volunteer.Volunteer;

import java.util.Date;

public class Walk {

    private final long id;
    private final long animalId;
    private final long volunteerId;
    private final Date walkTime;
    private Animal animal;
    private Volunteer volunteer;

    public Walk(long id, long animalId, long volunteerId, Date walkTime) {
        this.id = id;
        this.animalId = animalId;
        this.volunteerId = volunteerId;
        this.walkTime = walkTime;
    }

    public Walk(long animalId, long volunteerId, Date walkTime) {
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
        this.walkTime = animal.getLastWalkTime();
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

    public Date getWalkTime() {
        return walkTime;
    }

    public Animal getAnimal() {
        return animal;
    }

    public Volunteer getVolunteer() {
        if (volunteer != null) {
            return volunteer;
        } else {
            throw new NullPointerException();
        }
    }
}
