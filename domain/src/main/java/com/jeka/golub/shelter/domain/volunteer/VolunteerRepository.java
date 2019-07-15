package com.jeka.golub.shelter.domain.volunteer;

import java.util.List;

public interface VolunteerRepository {
    void add(Volunteer volunteer);

    List<Volunteer> getAll();

    List<Volunteer> getAvailableVolunteers();
}
