package com.jeka.golub.shelter.persistence;

import com.jeka.golub.shelter.domain.repositories.ShelterRepository;

public interface RepositoryAbstractFactory {

    ShelterRepository getShelterRepository();

}
