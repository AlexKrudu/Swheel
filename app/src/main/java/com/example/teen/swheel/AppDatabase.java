package com.example.teen.swheel;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Person.class, RandomPerson.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract PersonDao personDao();
    public abstract RandomPersonDao randomPersonDao();
}