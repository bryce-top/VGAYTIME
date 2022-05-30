package com.example.game.service;

import com.example.game.entity.Administrator;

public interface AdminService {
// 登陆
    boolean loginCheck(String email, String password);

// 审核游戏信息
    boolean gameCheck(int id);

    boolean updatePass(Administrator admin);

}
