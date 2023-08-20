package ru.opolonina.kataPP.service;

import org.springframework.stereotype.Service;
import ru.opolonina.kataPP.DAO.UserRepository;
import ru.opolonina.kataPP.model.User;


import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImp implements UserService {

    private final UserRepository userRepository;

    public UserServiceImp(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public User getUserById(int id) {
        Optional<User> user = userRepository.findById(id);
        return user.get();
    }

    @Override
    public void updateUser(User user) {
        userRepository.save(user);

    }

    @Override
    public void deleteUserById(int id) {
        userRepository.deleteById(id);
    }
}
