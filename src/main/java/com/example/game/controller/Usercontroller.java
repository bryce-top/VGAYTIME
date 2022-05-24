package com.example.game.controller;

import com.example.game.entity.Game;
import com.example.game.entity.User;
import com.example.game.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/do/user")
public class Usercontroller {
    @Resource
    private UserService service;
    @RequestMapping(value = "/showUser",method = RequestMethod.GET)
    public List<User> showUser() {
        System.out.println("查询用户数据:");
        List<User> list =service.getAllUser();
        System.out.println(list);

        return list;
    }


    @PostMapping("/login")
    public Boolean loginCheck(@Param("account") String account, @Param("password") String password){
        System.out.println("查询用户登录信息");
        System.out.println(account+"  "+password);
        return service.loginCheck(account, password);
    }
    @PostMapping("/register")
    public Boolean insertUser(@Param("account")String account,@Param("password")String password,@Param("email")String email,@Param("username")String username){
        User user=new User();
        user.setAccount(account);
        user.setPassword(password);
        user.setEmail(email);
        user.setUsername(username);
        user.setId("null");
        return service.insertUser(user);
    }
    @PostMapping("/getUserinfo")
    public User getUserinfo(@Param("account")String account){
        User user=service.getUserinfo(account);
        return user;
    }
}
