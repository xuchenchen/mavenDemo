package com.ryx.service.imp;

import com.ryx.dao.Classes;
import com.ryx.pojo.User;
import com.ryx.service.IUserService;
import org.springframework.stereotype.Service;

import java.util.List;
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
}
