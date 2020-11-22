package com.elec5619.easysports.service;

import com.elec5619.easysports.domain.User;

import java.util.List;

public interface UserService {

    int insert(User user);

    void delete(int userId);

    void update(User user);

    List<User> findAllUsers();

    User findById(int id);

    User findOneByProperty(String propertyName, Object value);

    List<User> findAllByProperty(String propertyName, Object value);

    boolean validate(User user);

    User findByEmail(String email);

}
