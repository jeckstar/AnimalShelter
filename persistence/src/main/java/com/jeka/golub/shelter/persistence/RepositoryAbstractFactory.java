package com.jeka.golub.shelter.persistence;

import com.jeka.golub.shelter.domain.animal.AnimalRepository;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;

public interface RepositoryAbstractFactory {

    ShelterRepository getShelterRepository();

    AnimalRepository getAnimalRepository();

    VolunteerRepository getVolunteerRepository();
}
