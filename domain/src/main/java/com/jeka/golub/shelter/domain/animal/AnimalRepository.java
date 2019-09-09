package com.jeka.golub.shelter.domain.animal;

import java.util.List;

public interface AnimalRepository {
    void add(Animal animal, long shelterId);

    List<Animal> getAll();

    Animal getById(long animalId);

    List<Animal> getByShelterId(long shelterId);

    void update(Animal animal, long shelterId);
}
