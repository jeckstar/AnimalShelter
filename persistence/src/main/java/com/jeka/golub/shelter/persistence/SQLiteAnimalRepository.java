package com.jeka.golub.shelter.persistence;

import com.jeka.golub.shelter.domain.Animal;
import com.jeka.golub.shelter.domain.repositories.AnimalRepository;
import com.jeka.golub.shelter.persistence.converters.AnimalEntityConverter;
import com.jeka.golub.shelter.persistence.shelter_database.dao.AnimalDao;
import com.jeka.golub.shelter.persistence.shelter_database.entity.AnimalEntity;

import java.util.ArrayList;
import java.util.List;

public class SQLiteAnimalRepository implements AnimalRepository {

    private final AnimalDao dao;
    private final AnimalEntityConverter animalEntityConverter;

    public SQLiteAnimalRepository(final AnimalDao dao, final AnimalEntityConverter animalEntityConverter) {
        this.dao = dao;
        this.animalEntityConverter = animalEntityConverter;
    }

    @Override
    public void add(Animal animal, long shelterId) {
        final AnimalEntity animalEntity = animalEntityConverter.convertForward(animal, shelterId);
        dao.insert(animalEntity);
    }

    @Override
    public List<Animal> getAll() {
        final List<Animal> animals = new ArrayList<>();
        final List<AnimalEntity> animalEntities = dao.getAll();
        for (AnimalEntity aEntity : animalEntities) {
            animals.add(animalEntityConverter.convertReverse(aEntity));
        }
        return animals;
    }

    @Override
    public List<Animal> getAllForCurrentShelter(long shelterId) {
        final List<Animal> animals = new ArrayList<>();

        final List<AnimalEntity> animalEntities = dao.getAllByShelterId(shelterId);

        for (AnimalEntity aEntity : animalEntities) {
            animals.add(animalEntityConverter.convertReverse(aEntity));
        }
        return animals;    }
}
