package com.ryx.service.imp;

import com.ryx.dao.Classes;
import com.ryx.dao.JieQianYongBean;
import com.ryx.mapper.UserMapper;
import com.ryx.pojo.User;
import com.ryx.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

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

    @Override
    public List<Classes> getClassAndrTeachersMaps() {
      List<Classes> classesList=  userMapper.getClassAndrTeachersMaps();
      List<Classes> classesLis2=  userMapper.getClassAndrTeachersMaps();
        classesList.addAll(classesLis2);
        return classesList;
    }

    @Override
    public List<Map> getMaps() {
        List<Map> maps1=  userMapper.getMaps();
        List<Map> maps2=  userMapper.getMaps();
        maps1.addAll(maps2);
        return maps1;
    }

    @Override
    public int editUser(User user) {
        return userMapper.editUser(user);
    }

    @Override
    public List<User> findUsersByPage(int page, int rows) {
        return userMapper.findUsersByPage(page,rows);
    }

    @Override
    public int insertJieQianYongBean(JieQianYongBean jieQianYongBean) {
        return userMapper.insertJieQianYongBean(jieQianYongBean);
    }
}
