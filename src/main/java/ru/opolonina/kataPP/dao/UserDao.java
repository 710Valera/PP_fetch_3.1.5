package ru.opolonina.kataPP.dao;


import org.springframework.data.jpa.repository.Query;
import ru.opolonina.kataPP.model.User;

import java.util.List;


public interface UserDao {


    List<User> getAllUsers();

    void addUser(User user);

    User getUserById(int id);


    void updateUser(User user);

    void deleteUserById(int id);
    

    @Query("Select u from User u left join fetch u.roles where u.firstName=:name")
    User findByUsername (String name);

}
