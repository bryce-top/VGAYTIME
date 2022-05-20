package com.example.game.service;

import com.example.game.entity.User;
import com.example.game.mapper.UserMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Resource
    private UserMapper mapper;
    public List<User> getAllUser(){
        System.out.println("进入UserService");
        List<User> list= new ArrayList<User>();
        list =mapper.selectAll();

        return list;
    }
    public Boolean loginCheck(String account,String password){
        System.out.println("进入logincheckService");
        String re=mapper.findPassword(account,password);
        System.out.println(re);
        if (re==null){
            return false;}
        if(re.equals(password)){
            return true;
        }else {
            System.out.println("false");
            return false;
        }
    }
    public boolean insertUser(User user){
        System.out.println("进入registerService");
        mapper.insertUser(user);
        return true;
    }


}
