package com.ryx.service;

import com.ryx.dao.Classes;
import com.ryx.pojo.User;

import java.util.List;
public interface IUserService {
    public List<User> getUsers();
    public int insertData();
    public int saveUser(User user);
    public User getUserById(String uid,String pswd);
    public Classes getMapUserAndUsers();
}
