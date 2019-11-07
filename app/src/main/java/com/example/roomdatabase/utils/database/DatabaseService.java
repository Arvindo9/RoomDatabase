package com.example.roomdatabase.utils.database;

import com.example.roomdatabase.utils.model.Users;

import java.util.List;

public interface DatabaseService {

    boolean saveUsers(Users users);

    List<String> getUserNames();

    List<Users> getUsers();

    boolean isUserExist(String name);

    Users getUser(String name);

}
