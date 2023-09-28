package ru.opolonina.kataPP.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.opolonina.kataPP.dto.UserDto;
import ru.opolonina.kataPP.model.User;
import ru.opolonina.kataPP.service.UserService;

import java.security.Principal;


@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/")
    public ResponseEntity<UserDto> getUser(Principal principal) {
        return new ResponseEntity<>(convertToUserDto(userService.findByUsername(principal.getName())), HttpStatus.OK);
    }

    public UserDto convertToUserDto(User user) {

        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(user, UserDto.class);

    }
}
