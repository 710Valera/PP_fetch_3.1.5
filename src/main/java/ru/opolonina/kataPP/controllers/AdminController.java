package ru.opolonina.kataPP.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.opolonina.kataPP.dto.UserDto;
import ru.opolonina.kataPP.model.User;
import ru.opolonina.kataPP.service.UserService;

import javax.validation.Valid;
import java.util.List;
import java.util.stream.Collectors;


@RestController
@RequestMapping("/admin")
public class AdminController {

    private final UserService userService;
    @Autowired
    public AdminController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/users")
    public ResponseEntity<List<UserDto>> getUsers() {
        return new ResponseEntity<>(userService.findAll().stream().map(this::convertToUserDto).collect(Collectors.toList()), HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable("id") int id) {
        return new ResponseEntity<>(convertToUserDto(userService.findUserById(id)), HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity <User> createUser(@Valid @RequestBody UserDto userDto, BindingResult result) {
        if(result.hasErrors()) {
            throw new IllegalArgumentException();
        }
        userService.saveUser(convertToUser(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PutMapping("/users")
    public ResponseEntity <User> updateUser(@Valid @RequestBody UserDto userDto, BindingResult result) {
        if(result.hasErrors()) {
            throw new IllegalArgumentException();
        }
        userService.updateUser(convertToUser(userDto));
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> deleteUser(@PathVariable("id") int id) {
        User user = userService.findUserById(id);
        if (user == null) {
            return ResponseEntity.notFound().build();
        }
        userService.deleteUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
    public User convertToUser(UserDto userDto) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(userDto, User.class);

    }

    public UserDto convertToUserDto(User user) {

          ModelMapper modelMapper = new ModelMapper();
          return modelMapper.map(user, UserDto.class);

    }
}
