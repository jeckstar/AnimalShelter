package com.jeka.golub.shelter.persistence.migration;

import androidx.annotation.NonNull;
import androidx.room.migration.Migration;
import androidx.sqlite.db.SupportSQLiteDatabase;

public abstract class DatabaseMigration {

    private DatabaseMigration() {

    }

    public static Migration MIGRATION_1_2 = new Migration(1, 2) {
        @Override
        public void migrate(@NonNull SupportSQLiteDatabase database) {
            database.execSQL("ALTER TABLE `vulunteers`\n" +
                    "  RENAME TO `volunteer`;");
            database.execSQL("CREATE TABLE `temp_walk_status`(\n" +
                    "    `id` INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL,\n" +
                    "    `animal_Id` INTEGER NOT NULL,\n" +
                    "    `volunteer_id` INTEGER NOT NULL,\n" +
                    "    `walk_time` INTEGER NOT NULL,\n" +
                    "    FOREIGN KEY(`animal_Id`)\n" +
                    "        REFERENCES `animals`(`id`) \n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION, \n" +
                    "    FOREIGN KEY(`volunteer_id`)\n" +
                    "        REFERENCES `volunteer`(`id`)\n" +
                    "        ON UPDATE NO ACTION\n" +
                    "        ON DELETE NO ACTION);\n");
            try {
                database.beginTransaction();
                database.execSQL("INSERT INTO `temp_walk_status`(`id`, `animal_Id`, `volunteer_id`, `walk_time`) \n" +
                        "SELECT `id`, `animal_Id`, `volunteer_id`, `walk_time` FROM `walk_status`");
                //TODO drop the old table and rename the new one
                database.execSQL("DROP TABLE `walk_status`");
                database.execSQL("ALTER TABLE `temp_walk_status` RENAME TO `walk_status`");
                database.setTransactionSuccessful();
            } catch (Exception ignored) {
            } finally {
                database.endTransaction();
            }
        }
    };

}
