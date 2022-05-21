package com.example.game.service;

import com.example.game.mapper.AdminMapper;
import com.example.game.mapper.GameMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminMapper adminMapper;
    @Autowired
    private GameMapper gameMapper;

    @Override
    public boolean loginCheck(String email, String password) {
        boolean flag=false;
        try{
            if(adminMapper.findPassword(email).getPassword().equals(password))
            flag=true;
        }catch(Exception e){
            e.printStackTrace();
        }
        return flag;
    }

    @Override
    public boolean gameCheck(int id) {
        boolean flag = false;
        try{
            gameMapper.check(id).setStatus(true);
                flag = true;
        }catch (Exception e){
            e.printStackTrace();
        }
        return flag;
    }
}
