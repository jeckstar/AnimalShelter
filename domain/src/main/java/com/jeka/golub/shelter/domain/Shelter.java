package com.jeka.golub.shelter.domain;

import java.util.ArrayList;
import java.util.List;

public class Shelter {

    private final long id;
    private final String title;
    private final String address;
    private final List<Animal> animals;
    private final String phoneNumber;

    public Shelter(long id, String title, String address, String phoneNumber, List<Animal> animals) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.animals = animals;
    }

    public Shelter(String title, String address, String phoneNumber, List<Animal> animals) {
        this.animals = animals;
        this.id = 0L;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Iterable<Animal> getAnimals() {
        return new ArrayList<>(animals);
    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
}
