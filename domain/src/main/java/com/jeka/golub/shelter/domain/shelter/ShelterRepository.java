package com.jeka.golub.shelter.domain.shelter;

import java.util.List;

public interface ShelterRepository {
    void add(Shelter shelter);

    List<Shelter> getAll();

}
