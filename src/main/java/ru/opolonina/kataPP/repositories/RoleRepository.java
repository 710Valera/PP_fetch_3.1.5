package ru.opolonina.kataPP.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.opolonina.kataPP.model.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
