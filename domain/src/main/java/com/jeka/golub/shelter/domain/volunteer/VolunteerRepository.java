package com.jeka.golub.shelter.domain.volunteer;

import com.jeka.golub.shelter.domain.animal.Animal;

import java.util.List;

public interface VolunteerRepository {
    void add(Volunteer volunteer);

    List<Volunteer> getAll();

    List<Volunteer> getAvailableVolunteers();

    Volunteer getById(long currentVolunteerId);
}
