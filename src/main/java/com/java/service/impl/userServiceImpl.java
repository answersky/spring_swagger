package com.java.service.impl;

import com.java.dao.UserDao;
import com.java.domain.User;
import com.java.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by liuf on 2016/7/3.
 */
@Service
public class userServiceImpl implements UserService{
    @Resource
    private UserDao userDao;


    @Override
    public User findUserById(int id) {
        return userDao.findUserById(id);
    }

    @Override
    public List<User> findUsers() {
        return userDao.findUsers();
    }

    @Override
    public User findByUsername(String username) {
        User user=null;
        Map map=userDao.findByUsername(username);
        if(map!=null){
            user=new User();
            String name= (String) map.get("username");
            String password= (String) map.get("password");
            String role= (String) map.get("role");
            user.setName(name);
            user.setPassword(password);
            user.setRole(role);
        }
        return user;
    }
}
