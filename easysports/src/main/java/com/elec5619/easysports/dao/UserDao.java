package com.elec5619.easysports.dao;

import com.elec5619.easysports.domain.User;

import java.util.List;

public interface UserDao {
    User getById(int id);
    User getByEmail(String email);
    int saveUser(User user);
    void deleteById(int id);
    List<User> findAllUsers();
    void updateUser(User user);
    boolean validate(User user);
    List<User> findAllByProperty(String propertyName, Object value);
    User findOneByProperty(String propertyName, Object value);

}
