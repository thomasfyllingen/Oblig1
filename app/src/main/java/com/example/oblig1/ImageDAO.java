package com.example.oblig1;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ImageDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Image... images);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertImage( Image image);
    @Delete
    void delete(Image image);

    @Query("Select * from image")
    List<Image> getAll();
}
