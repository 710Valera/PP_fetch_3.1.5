package ru.opolonina.kataPP.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.opolonina.kataPP.dao.RoleDao;
import ru.opolonina.kataPP.model.Role;

import java.util.List;

@Service
@Component
public class RoleServiceImp implements RoleService {
    private RoleDao roleDao;

    @Autowired
    public RoleServiceImp(RoleDao roleDao) {
        this.roleDao = roleDao;
    }

    public List<Role> findAll() {
        return roleDao.findAll();
    }
}
