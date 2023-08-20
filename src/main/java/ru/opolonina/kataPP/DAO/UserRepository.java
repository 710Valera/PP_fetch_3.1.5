package ru.opolonina.kataPP.DAO;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.opolonina.kataPP.model.User;


public interface UserRepository extends JpaRepository<User, Integer> {

}
