package ru.opolonina.kataPP.service;


import ru.opolonina.kataPP.model.Role;
import ru.opolonina.kataPP.model.User;

import java.util.List;
import java.util.Set;


public interface UserService {

    List<User> findAll();

    void saveUser(User user);

    User findUserById(int id);


    void updateUser(User user);

    void deleteUserById(int id);

    User findByUsername(String name);

    public Set<Role> getSetOfRoles(List<String> rolesId);
}
