package com.jeka.golub.shelter.domain.repositories;

import com.jeka.golub.shelter.domain.Animal;

import java.util.List;

public interface AnimalRepository {
    void add(Animal animal, long shelterId);

    List<Animal> getAll();

    List<Animal> getAllForCurrentShelter(long shelterId);

}
