package com.elec5619.easysports.dao.impl;

import com.elec5619.easysports.dao.UserDao;
import com.elec5619.easysports.domain.User;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional(readOnly = false)
public class UserDaoImpl extends AbstractDao<Integer, User>  implements UserDao {

    @Override
    public User getById(int id) {
        return getByKey(id);
    }

    @Override
    public User getByEmail(String email) {
        return getOneByProperty("email", email);
    }

    @Override
    public int saveUser(User user) {
        save(user);
        return user.getId();
    }

    @Override
    public void deleteById(int id) {
        delete(getByKey(id));
    }

    @Override
    public List<User> findAllUsers() {
        return loadAll();
    }

    @Override
    public void updateUser(User user) {
        update(user);
    }

    @Override
    public boolean validate(User user) {
        return false;
    }

    @Override
    public List<User> findAllByProperty(String propertyName, Object value) {
        return findAllByProperty(propertyName, value);
    }

    @Override
    public User findOneByProperty(String propertyName, Object value) {
        return findOneByProperty(propertyName, value);
    }


}
