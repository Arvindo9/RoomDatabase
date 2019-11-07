package com.example.roomdatabase.utils.database;

import android.content.Context;

import androidx.room.Room;

import com.example.roomdatabase.utils.model.Users;

import org.jetbrains.annotations.NotNull;

import java.util.List;

public class Database implements DatabaseService {

    private final AppDatabase appDatabase;
    private static Database database;

    public static Database getInstance(Context context){
        if(database == null){
            database = new Database(getDataBase(context));
        }

        return database;
    }

    @NotNull
    private static AppDatabase getDataBase(Context context) {
        return Room.databaseBuilder(context, AppDatabase.class,
                "MyDataBase").fallbackToDestructiveMigration()
//                .openHelperFactory(factory)
                .build();
    }

    public Database(AppDatabase appDatabase){
        this.appDatabase = appDatabase;
    }

    @Override
    public boolean saveUsers(final Users users) {
        appDatabase.userDao().insert(users);
        return true;
    }

    @Override
    public List<String> getUserNames() {
        return appDatabase.userDao().getUserNames();
    }

    @Override
    public List<Users> getUsers() {
        return appDatabase.userDao().getUserList();
    }

    @Override
    public boolean isUserExist(String name) {
        return false;
    }

    @Override
    public Users getUser(String name) {
        return appDatabase.userDao().getUser(name);
    }
}
