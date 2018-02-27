package com.springboot.configuration.initializer;

import com.springboot.model.Role;
import com.springboot.model.User;
import com.springboot.service.RoleService;
import com.springboot.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.HashSet;
import java.util.Set;

public class TestDataInitializer {


    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;


    private void init() throws Exception {

        Role roleAdmin = new Role();
        roleAdmin.setName("ADMIN");
        roleService.addRole(roleAdmin);

        Role roleUser = new Role();
        roleUser.setName("USER");
        roleService.addRole(roleUser);

        //-----Admin_1-------
        User admin = new User();
        admin.setLogin("admin");
        admin.setPassword("admin");
        admin.setName("Melissa");
        Set<Role> adminRoles = new HashSet<>();
        adminRoles.add(roleAdmin);
        adminRoles.add(roleUser);
        admin.setRoles(adminRoles);

        userService.addUser(admin);
        //-----User_1-------
        User user = new User();
        user.setLogin("user");
        user.setPassword("user");
        user.setName("Henry");
        Set<Role> userRoles = new HashSet<>();
        userRoles.add(roleUser);
        user.setRoles(userRoles);

        userService.addUser(user);

        //-----User_2-------
        User user2 = new User();
        user2.setLogin("user2");
        user2.setPassword("user2");
        user2.setName("Mark");
        Set<Role> userRoles2 = new HashSet<>();
        userRoles2.add(roleUser);
        user2.setRoles(userRoles2);

        userService.addUser(user2);

        //-----User_3-------
        User user3 = new User();
        user3.setLogin("user3");
        user3.setPassword("user3");
        user3.setName("John");
        Set<Role> userRoles3 = new HashSet<>();
        userRoles3.add(roleUser);
        user3.setRoles(userRoles3);

        userService.addUser(user3);

    }
}
