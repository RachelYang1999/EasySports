package com.elec5619.easysports.service.impl;

import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.domain.User;
import com.elec5619.easysports.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

//    public UserServiceImpl(UserDao userDao) {
//        this.userDao = userDao;
//    }

    @Override
    public int insert(User user){
        return userDao.saveUser(user);
    }

    @Override
    public void delete(int userId){
        userDao.deleteById(userId);
    }

    @Override
    public void update(User user){
        userDao.updateUser(user);
    }

    @Override
    public List<User> findAllUsers(){
        return userDao.findAllUsers();
    }

    @Override
    public User findById(int id){
        return userDao.getById(id);
    }

    @Override
    public User findByEmail(String email){
        return userDao.getByEmail(email);
    }

    @Override
    public User findOneByProperty(String propertyName, Object value) {
        return userDao.findOneByProperty(propertyName, value);
    }

    @Override
    public List<User> findAllByProperty(String propertyName, Object value) {
        return userDao.findAllByProperty(propertyName, value);
    }

    @Override
    public boolean validate(User user) {
        return userDao.validate(user);
    }


}
