package com.jeka.golub.shelter.domain.walk;

public class Walk {

    private final long id;
    private final long animalId;
    private final long volunteerId;
    private final long walkTime;

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
}
