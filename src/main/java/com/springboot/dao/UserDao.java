package com.springboot.dao;

import com.springboot.model.User;
import java.util.List;

public interface UserDao {
    List<User> getAllUser();

    void addUser(User user);
    void updateUser(User user);

    void deleteUser(int id);

    User getUserById(int id);
    User getUserByLogin(String login);
}
