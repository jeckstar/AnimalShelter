package com.jeka.golub.shelter.persistence;

import com.jeka.golub.shelter.domain.Shelter;
import com.jeka.golub.shelter.domain.repositories.ShelterRepository;
import com.jeka.golub.shelter.persistence.converters.ShelterEntityConverter;
import com.jeka.golub.shelter.persistence.shelter_database.dao.ShelterDao;
import com.jeka.golub.shelter.persistence.shelter_database.entity.ShelterEntity;

import java.util.concurrent.Executor;

public class SQLiteShelterRepository implements ShelterRepository {

    private final ShelterDao dao;
    private final ShelterEntityConverter shelterEntityConverter;
    private final Executor executor;

    public SQLiteShelterRepository(final ShelterDao dao, final ShelterEntityConverter shelterEntityConverter, Executor executor) {
        this.dao = dao;
        this.shelterEntityConverter = shelterEntityConverter;
        this.executor = executor;
    }

    @Override
    public void add(Shelter shelter) {
        executor.execute(() -> {
            final ShelterEntity shelterEntity = shelterEntityConverter.convertForward(shelter);
            dao.insert(shelterEntity);
        });
    }
}
