package com.ryx.service.imp;

import com.ryx.dao.Classes;
import com.ryx.dao.JieQianYongBean;
import com.ryx.pojo.User;
import com.ryx.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service("UserService2Impl")
public class UserService2Impl implements IUserService {
    @Override
    public List<User> getUsers() {
        return null;
    }

    @Override
    public int insertData() {
        return 0;
    }

    @Override
    public int saveUser(User user) {
        return 0;
    }

    @Override
    public User getUserById(String uid, String pswd) {
        return null;
    }

    @Override
    public Classes getMapUserAndUsers() {
        return null;
    }

    @Override
    public List<Classes> getClassAndrTeachersMaps() {
        return null;
    }

    @Override
    public List<Map> getMaps() {
        return null;
    }

    @Override
    public int editUser(User user) {
        return 0;
    }

    @Override
    public List<User> findUsersByPage(int page, int rows) {
        return null;
    }

    @Override
    public int insertJieQianYongBean(JieQianYongBean jieQianYongBean) {
        return 0;
    }
}
