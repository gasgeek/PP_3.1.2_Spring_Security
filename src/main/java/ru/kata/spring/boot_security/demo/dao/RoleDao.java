package ru.kata.spring.boot_security.demo.dao;

import ru.kata.spring.boot_security.demo.model.Role;

import java.util.List;
import java.util.Set;

public interface RoleDao {



    List<Role> getListRoles();

    void addRole(Role role);

    Role getById(Long id);

    Role getByName(String name);
}