package com.springboot.dao;


import com.springboot.model.Role;

public interface RoleDao {
    Role getRoleByRoleName(String roleName);
    void addRole(Role roleName);

}
