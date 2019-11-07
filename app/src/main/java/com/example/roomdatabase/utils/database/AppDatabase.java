package com.example.roomdatabase.utils.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.example.roomdatabase.utils.database.dao.UserDao;
import com.example.roomdatabase.utils.model.Users;
import com.example.roomdatabase.utils.database.util.DateConverter;

@Database(entities = {Users.class},
        version = 1, exportSchema = false)
@TypeConverters({DateConverter.class})
public abstract class AppDatabase extends RoomDatabase {

    public abstract UserDao userDao();
}
