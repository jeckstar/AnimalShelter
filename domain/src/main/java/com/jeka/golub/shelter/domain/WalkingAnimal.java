package com.jeka.golub.shelter.domain;

public class WalkingAnimal {

    private final long id;
    private final long animalId;
    private final long shelterId;
    private final long walkTime;

    public WalkingAnimal(long id, long animalId, long shelterId, long walkTime) {
        this.id = id;
        this.animalId = animalId;
        this.shelterId = shelterId;
        this.walkTime = walkTime;
    }

    public WalkingAnimal(long animalId, long shelterId, long walkTime) {
        this.id = 0L;
        this.animalId = animalId;
        this.shelterId = shelterId;
        this.walkTime = walkTime;
    }

    public long getId() {
        return id;
    }

    public long getAnimalId() {
        return animalId;
    }

    public long getShelterId() {
        return shelterId;
    }

    public long getWalkTime() {
        return walkTime;
    }
}
