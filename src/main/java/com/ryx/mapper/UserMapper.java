package com.ryx.mapper;

import com.ryx.dao.Classes;
import com.ryx.pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.Select;

import java.util.List;
public interface UserMapper {

    @Select("select * from t_user where id=#{0} and password=#{1}")
    public User getUserById(String uid,String pswd);

    public List<User> getUsers();

    public int insertData();
    @Insert("INSERT INTO t_user(userName,password) values (#{userName},#{password})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    public int saveUser(User user);

    public Classes getMapUserAndUsers();
    public Classes getClassBiao();
}
