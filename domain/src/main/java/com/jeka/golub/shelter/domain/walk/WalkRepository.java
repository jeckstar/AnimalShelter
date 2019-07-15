package com.jeka.golub.shelter.domain.walk;

import java.util.List;

public interface WalkRepository {
    void add(Walk walk);

    List<Walk> getAll();

}
