package com.java.dao;

import com.java.domain.User;

import java.util.List;
import java.util.Map;

/**
 * Created by liuf on 2016/7/3.
 */
public interface UserDao {
    public void insertUser(User user);

    public User findUserById(int id);

    List<User> findUsers();

    Map findByUsername(String username);
}
