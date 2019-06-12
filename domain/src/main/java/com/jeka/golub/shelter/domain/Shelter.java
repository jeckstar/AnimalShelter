package com.jeka.golub.shelter.domain;

public class Shelter {

    private final long id;
    private final String title;
    private final String address;
    private final String phoneNumber;

    public Shelter(long id, String title, String address, String phoneNumber) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public Shelter(String title, String address, String phoneNumber) {
        this.id = 0L;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
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
