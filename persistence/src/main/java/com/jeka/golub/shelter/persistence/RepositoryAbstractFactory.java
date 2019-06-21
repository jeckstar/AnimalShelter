package com.jeka.golub.shelter.persistence;

import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

public interface RepositoryAbstractFactory {

    ShelterRepository getShelterRepository();

    AnimalRepository getAnimalRepository();
}
