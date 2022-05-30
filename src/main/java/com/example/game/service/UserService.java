package com.example.game.service;

import com.example.game.entity.User;
import com.example.game.mapper.UserMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;

import org.springframework.stereotype.Service;
import com.example.game.DAO.SnowflakeIdWorker;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class UserService {
    @Resource
    private UserMapper mapper;
    private SnowflakeIdWorker generate ;
    public List<User> getAllUser(){
        System.out.println("进入UserService");
        List<User> list= new ArrayList<User>();
        list =mapper.selectAll();

        return list;
    }
    public int loginCheck(String account,String password){
        System.out.println("进入logincheckService");
        String re=mapper.findPassword(account,password);
        System.out.println(re);
        if (re==null){
            return 0;}
        if(re.equals(password)){
            return mapper.findId(account);
        }else {
            System.out.println("false");
            return 0;
        }
    }
    public boolean insertUser(User user){
        System.out.println("进入registerService");
        SnowflakeIdWorker idWorker = new SnowflakeIdWorker(0, 0);
        long id= idWorker.nextId();
        user.setId(Long.toString(id));
        mapper.insertUser(user);
        return true;
    }
    public User getUserinfo(String account){
        System.out.println("进入getUserinfoService");
        User user=mapper.getUserinfo(account);
        return user;
    }
    public boolean updateUser(User user){
        System.out.println("进入updateUserService");
        mapper.updateUser(user);
        return true;
    }
    public boolean deleteUser(User user){
        System.out.println("进入deleteUserService");
        mapper.deleteUser(user);
        return true;
    }


}
