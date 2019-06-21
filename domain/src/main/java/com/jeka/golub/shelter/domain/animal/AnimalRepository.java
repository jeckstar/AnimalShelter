package com.jeka.golub.shelter.domain.animal;

import java.util.List;

public interface AnimalRepository {
    void add(Animal animal, long shelterId);

    List<Animal> getAll();

    List<Animal> getByShelterId(long shelterId);

}
