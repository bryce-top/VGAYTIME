package com.example.game.mapper;

import com.example.game.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface UserMapper {
    public List<User> selectAll();
    public String findAccount(String account);
    public String findPassword(@Param("account")String account,@Param("password")String password);
    public void insertUser(@Param("user") User user);

}
