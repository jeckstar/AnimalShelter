package com.jeka.golub.shelter.persistence.migration;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class DatabaseMigrationRouteTable {

    private DatabaseMigrationRouteTable() {

    }

    public static Migration MIGRATION_2_3 = new Migration(2, 3) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("CREATE TABLE `route`(\n" +
                    "    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                    "    `latitude` TEXT NOT NULL,\n" +
                    "    `longitude` TEXT NOT NULL,\n" +
                    "    `walk_id` INTEGER NOT NULL,\n" +
                    "    `index` INTEGER NOT NULL\n" +
                    "    );\n");
        }
    };

}
