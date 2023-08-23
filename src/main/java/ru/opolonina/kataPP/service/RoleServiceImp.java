package ru.opolonina.kataPP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.opolonina.kataPP.model.Role;
import ru.opolonina.kataPP.repositories.RoleRepository;

import java.util.List;

@Service
public class RoleServiceImp {
    private RoleRepository roleRepository;

    @Autowired
    public RoleServiceImp(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public List<Role> getAllRoles() {
        return roleRepository.findAll();
    }
}
