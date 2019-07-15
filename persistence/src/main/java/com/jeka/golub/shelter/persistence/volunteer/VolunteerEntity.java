package com.jeka.golub.shelter.persistence.volunteer;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.Index;
import androidx.room.PrimaryKey;

import static com.jeka.golub.shelter.persistence.volunteer.VolunteerEntity.ID;
import static com.jeka.golub.shelter.persistence.volunteer.VolunteerEntity.TABLE_NAME;

@Entity(tableName = TABLE_NAME, indices = {@Index(value = {ID}, unique = true)})
public class VolunteerEntity {

    public static final String TABLE_NAME = "volunteers";
    public static final String ID = "id";
    public static final String FIRST_NAME = "first_name";
    public static final String LAST_NAME = "last_name";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    private final long id;
    @ColumnInfo(name = FIRST_NAME)
    private final String firstName;
    @ColumnInfo(name = LAST_NAME)
    private final String lastName;

    public VolunteerEntity(long id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Ignore
    public VolunteerEntity(String firstName, String lastName) {
        this.id = 0L;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    public long getId() {
        return id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
