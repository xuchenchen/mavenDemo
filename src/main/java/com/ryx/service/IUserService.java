package com.ryx.service;

import com.ryx.dao.Classes;
import com.ryx.dao.JieQianYongBean;
import com.ryx.pojo.User;

import java.util.List;
import java.util.Map;

public interface IUserService {
    public List<User> getUsers();
    public int insertData();
    public int saveUser(User user);
    public User getUserById(String uid,String pswd);
    public Classes getMapUserAndUsers();
    public List<Classes> getClassAndrTeachersMaps();
    public List<Map> getMaps();
    public int editUser(User user);
    public List<User> findUsersByPage(int page,int rows );
    public int insertJieQianYongBean(JieQianYongBean jieQianYongBean);

}
