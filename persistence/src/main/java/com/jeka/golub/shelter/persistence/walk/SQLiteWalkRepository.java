package com.jeka.golub.shelter.persistence.walk;

import com.jeka.golub.shelter.domain.walk.Walk;
import com.jeka.golub.shelter.domain.walk.WalkRepository;

import java.util.ArrayList;
import java.util.List;

public class SQLiteWalkRepository implements WalkRepository {

    private final WalkDao dao;
    private final WalkEntityConverter walkEntityConverter;

    public SQLiteWalkRepository(final WalkDao dao, final WalkEntityConverter walkEntityConverter) {
        this.dao = dao;
        this.walkEntityConverter = walkEntityConverter;
    }

    @Override
    public void add(Walk walk) {
        final WalkEntity walkEntity = walkEntityConverter.convertForward(walk);
        dao.insert(walkEntity);
    }

    @Override
    public long getWalkId(Walk walk) {
        final WalkEntity walkEntity = walkEntityConverter.convertForward(walk);
        return dao.getId(
                walkEntity.getAnimalId(),
                walkEntity.getVolunteerId(),
                walkEntity.getWalkTime());
    }

    @Override
    public List<Walk> getAllWalkByAnimalId(long currentAnimal) {
        final List<Walk> walks = new ArrayList<>();
        final List<WalkEntity> walkEntities = dao.getAllByAnimalId(currentAnimal);
        for (WalkEntity walkEntity : walkEntities) {
            walks.add(walkEntityConverter.convertReverse(walkEntity));
        }
        return walks;
    }

    @Override
    public List<Walk> getAll() {
        final List<WalkEntity> walkEntities = dao.getAll();
        final List<Walk> walks = new ArrayList<>(walkEntities.size());
        for (WalkEntity wEntity : walkEntities) {
            walks.add(walkEntityConverter.convertReverse(wEntity));
        }
        return walks;
    }
}
