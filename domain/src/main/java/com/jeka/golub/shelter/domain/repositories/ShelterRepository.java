package com.jeka.golub.shelter.domain.repositories;

import com.jeka.golub.shelter.domain.Shelter;

import java.util.List;

public interface ShelterRepository {
    void add(Shelter shelter);

    List<Shelter> getAll();

}
