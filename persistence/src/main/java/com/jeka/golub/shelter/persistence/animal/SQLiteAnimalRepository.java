package com.jeka.golub.shelter.persistence.animal;

import com.jeka.golub.shelter.domain.animal.Animal;
import com.jeka.golub.shelter.domain.animal.AnimalRepository;

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
    public Animal getById(long animalId) {
        AnimalEntity animalEntity = dao.getById(animalId);
        return animalEntityConverter.convertReverse(animalEntity);
    }

    @Override
    public List<Animal> getByShelterId(long shelterId) {
        final List<Animal> animals = new ArrayList<>();

        final List<AnimalEntity> animalEntities = dao.getAllByShelterId(shelterId);

        for (AnimalEntity aEntity : animalEntities) {
            animals.add(animalEntityConverter.convertReverse(aEntity));
        }
        return animals;    }

    @Override
    public void update(Animal animal,  long shelterId) {
        final AnimalEntity animalEntity = animalEntityConverter.convertForward(animal, shelterId);
        dao.update(animalEntity);
    }
}
