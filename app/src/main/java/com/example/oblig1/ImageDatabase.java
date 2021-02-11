package com.example.oblig1;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

@Database(entities = {Image.class}, version = 1)
public abstract class ImageDatabase extends RoomDatabase {
    public abstract ImageDAO imageDAO();
    private static ImageDatabase INSTANCE;

    static ImageDatabase getDatabase(final Context context) {
        if (INSTANCE == null) {
            synchronized (ImageDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                            ImageDatabase.class,
                            "imagedb").allowMainThreadQueries().build();
                }
            }
        }
        return INSTANCE;
    }
}
