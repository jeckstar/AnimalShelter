package com.jeka.golub.shelter.persistence.volunteer;

import com.jeka.golub.shelter.domain.volunteer.Volunteer;
import com.jeka.golub.shelter.domain.volunteer.VolunteerRepository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SQLiteVolunteerRepository implements VolunteerRepository {

    private final VolunteerDao dao;
    private final VolunteerEntityConverter volunteerEntityConverter;

    public SQLiteVolunteerRepository(final VolunteerDao dao, final VolunteerEntityConverter volunteerEntityConverter) {
        this.dao = dao;
        this.volunteerEntityConverter = volunteerEntityConverter;
    }

    @Override
    public void add(Volunteer volunteer) {
        final VolunteerEntity volunteerEntity = volunteerEntityConverter.convertForward(volunteer);
        dao.insert(volunteerEntity);
    }

    @Override
    public List<Volunteer> getAll() {
        final List<Volunteer> volunteers = new ArrayList<>();
        final List<VolunteerEntity> volunteerEntity = dao.getAll();
        for (VolunteerEntity vEntity : volunteerEntity) {
            volunteers.add(volunteerEntityConverter.convertReverse(vEntity));
        }
        return volunteers;
    }

    @Override
    public List<Volunteer> getAvailableVolunteers() {
        final List<Volunteer> volunteers = new ArrayList<>();
        final long now = new Date().getTime();
        final List<VolunteerEntity> volunteerEntity = dao.getAvailable(now);
        for (VolunteerEntity vEntity : volunteerEntity) {
            volunteers.add(volunteerEntityConverter.convertReverse(vEntity));
        }
        return volunteers;
    }

    @Override
    public Volunteer getById(long currentVolunteerId) {
        VolunteerEntity volunteerEntity = dao.getById(currentVolunteerId);
        return volunteerEntityConverter.convertReverse(volunteerEntity);
    }
}
