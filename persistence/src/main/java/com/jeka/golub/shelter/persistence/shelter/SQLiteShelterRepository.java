package com.jeka.golub.shelter.persistence.shelter;

import com.jeka.golub.shelter.domain.shelter.Shelter;
import com.jeka.golub.shelter.domain.shelter.ShelterRepository;

import java.util.ArrayList;
import java.util.List;

public class SQLiteShelterRepository implements ShelterRepository {

    private final ShelterDao dao;
    private final ShelterEntityConverter shelterEntityConverter;

    public SQLiteShelterRepository(final ShelterDao dao, final ShelterEntityConverter shelterEntityConverter) {
        this.dao = dao;
        this.shelterEntityConverter = shelterEntityConverter;
    }

    @Override
    public void add(Shelter shelter) {
        final ShelterEntity shelterEntity = shelterEntityConverter.convertForward(shelter);
        dao.insert(shelterEntity);
    }

    @Override
    public List<Shelter> getAll() {
        final List<Shelter> shelters = new ArrayList<>();
        final List<ShelterEntity> sheltersEntity = dao.getAll();
        for (ShelterEntity sEntity : sheltersEntity) {
            shelters.add(shelterEntityConverter.convertReverse(sEntity));
        }
        return shelters;
    }
}
