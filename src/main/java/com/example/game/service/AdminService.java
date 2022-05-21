package com.example.game.service;

public interface AdminService {
// 登陆
    boolean loginCheck(String email, String password);

// 审核游戏信息
    boolean gameCheck(int id);

}
