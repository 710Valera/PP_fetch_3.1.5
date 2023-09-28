package ru.opolonina.kataPP.service.imp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import ru.opolonina.kataPP.dao.RoleDao;
import ru.opolonina.kataPP.model.Role;
import ru.opolonina.kataPP.service.RoleService;

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
        return roleDao.allRoles();
    }
    public Role getRoleById(int id) {
        return roleDao.getRoleById(id);
    }
}
