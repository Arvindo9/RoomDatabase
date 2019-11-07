package com.example.roomdatabase.utils.database.dao;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.example.roomdatabase.utils.model.Users;

import java.util.List;

@Dao
public interface UserDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(Users flag);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<Users> flagList);

    @Query("SELECT name FROM users")
    List<String> getUserNames();

    @Query("SELECT * FROM users")
    List<Users> getUserList();

    @Query("SELECT * FROM users where name = :name")
    Users getUser(String name);
}
