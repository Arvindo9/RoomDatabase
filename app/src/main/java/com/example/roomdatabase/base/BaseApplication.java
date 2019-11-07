package com.example.roomdatabase.base;

import android.app.Application;

import androidx.room.Room;

import com.example.roomdatabase.utils.database.AppDatabase;

public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

//        setUpDb();
    }

    private void setUpDb() {
        Room.databaseBuilder(this, AppDatabase.class, "MyDataBase").fallbackToDestructiveMigration()
//                .openHelperFactory(factory)
                .build();
    }
}
