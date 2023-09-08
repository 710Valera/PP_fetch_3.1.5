package ru.opolonina.kataPP.service;


import ru.opolonina.kataPP.model.User;

import java.util.List;


public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    User findUserById(int id);


    void updateUser(User user, int id);

    void deleteUserById(int id);

    User findByUsername(String name);
}
