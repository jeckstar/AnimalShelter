package com.jeka.golub.shelter.domain.repositories;

import com.jeka.golub.shelter.domain.Animal;
import com.jeka.golub.shelter.domain.Volunteer;

public interface WalkRepository {

    void takeAnimalForWalk(final Volunteer volunteer, final Animal animal);

}
