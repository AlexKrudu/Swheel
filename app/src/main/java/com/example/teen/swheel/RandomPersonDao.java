package com.example.teen.swheel;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import java.util.List;
@Dao
public interface RandomPersonDao {
    @Query("SELECT * FROM randomperson")
    List<RandomPerson> getAll();

    @Insert
    void insert(RandomPerson person);

    @Query("SELECT * from randomperson where name = :name limit 1")
    RandomPerson getOneByName(String name);

    @Update
    void update(RandomPerson person);

    @Delete
    void delete(RandomPerson person);
}
