package com.jeka.golub.shelter.persistence.route;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import static com.jeka.golub.shelter.persistence.route.LocationEntity.TABLE_NAME;

@Entity(tableName = TABLE_NAME)
public class LocationEntity {

    public static final String TABLE_NAME = "route";
    public static final String ID = "id";
    public static final String LATITUDE = "latitude";
    public static final String LONGITUDE = "longitude";
    public static final String WALK_ID = "walk_id";
    public static final String INDEX = "index";

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = ID)
    private final long id;
    @ColumnInfo(name = LATITUDE)
    private final String latitude;
    @ColumnInfo(name = LONGITUDE)
    private final String longitude;
    @ColumnInfo(name = WALK_ID)
    private final long walk_id;
    @ColumnInfo(name = INDEX)
    private final long index;

    public LocationEntity(long id, String latitude, String longitude, long walk_id, long index) {
        this.id = id;
        this.latitude = latitude;
        this.longitude = longitude;
        this.walk_id = walk_id;
        this.index = index;
    }

    @Ignore
    public LocationEntity(String latitude, String longitude, long walk_id, long index) {
        this(0L, latitude, longitude, walk_id, index);
    }

    public long getId() {
        return id;
    }

    public String getLatitude() {
        return latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public long getWalk_id() {
        return walk_id;
    }

    public long getIndex() {
        return index;
    }
}
