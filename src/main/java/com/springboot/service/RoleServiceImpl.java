package com.springboot.service;

import com.springboot.dao.RoleDao;
import com.springboot.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceImpl implements RoleService{

    @Autowired
    private RoleDao roleDao;

    public void addRole(Role role) {
        roleDao.addRole(role);
    }
}
