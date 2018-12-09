package com.ryx.service.imp;

import com.ryx.dao.Classes;
import com.ryx.mapper.UserMapper;
import com.ryx.pojo.User;
import com.ryx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service("UserServiceImpl")
public class UserServiceImpl implements IUserService {
    @Autowired
    private UserMapper userMapper;
    @Override
    public List<User> getUsers() {
        return userMapper.getUsers();
    }

    @Override
    public int insertData() {
        return userMapper.insertData();
    }

    @Override
    public int saveUser(User user) {
        return userMapper.saveUser(user);
    }

    @Override
    public User getUserById(String uid,String pswd) {
        return userMapper.getUserById(uid,pswd);
    }

    @Override
    public Classes getMapUserAndUsers() {
        return userMapper.getClassBiao();
    }
}
