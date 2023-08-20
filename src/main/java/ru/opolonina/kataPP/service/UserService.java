package ru.opolonina.kataPP.service;


import ru.opolonina.kataPP.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(int id);


    void updateUser(User user);

    void deleteUserById(int id);
}
