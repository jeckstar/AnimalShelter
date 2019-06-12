package com.jeka.golub.shelter.persistence.shelter_database.entity;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static com.jeka.golub.shelter.persistence.shelter_database.entity.ShelterEntity.TABLE_NAME;
import static com.jeka.golub.shelter.persistence.shelter_database.entity.ShelterEntity.TITLE;

@Entity(tableName = TABLE_NAME, indices = {@Index(value = {TITLE}, unique = true)})
public class ShelterEntity {

    public static final String TABLE_NAME = "shelters";
    public static final String ID = "id";
    public static final String TITLE = "title";
    public static final String ADDRESS = "address";
    public static final String PHONE_NUMBER = "phone_number";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    private final long id;
    @ColumnInfo(name = TITLE)
    private final String title;
    @ColumnInfo(name = ADDRESS)
    private final String address;
    @ColumnInfo(name = PHONE_NUMBER)
    private final String phoneNumber;

    public ShelterEntity(long id, String title, String address, String phoneNumber) {
        this.id = id;
        this.title = title;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    @Ignore
    public ShelterEntity( String title, String address, String phoneNumber) {
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
