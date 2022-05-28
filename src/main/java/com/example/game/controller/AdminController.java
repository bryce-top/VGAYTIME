package com.example.game.controller;

import com.example.game.entity.Administrator;
import com.example.game.entity.Game;
import com.example.game.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/do/admin")
public class AdminController {
    @Autowired
    private AdminService service;

    @RequestMapping(value = "/adminLogin", method = RequestMethod.POST)
    public Boolean loginCheck(@RequestBody Administrator admin){
        String email = admin.getEmail();
        String password = admin.getPassword();
        System.out.println("查询管理员登录信息");
        System.out.println(email);
        System.out.println(password);
        return service.loginCheck(email, password);
    }

    @RequestMapping(value = "/gameCheck", method = RequestMethod.POST)
    public Boolean gameCheck(@RequestBody Game game){
        int id = game.getId();
        System.out.println("gameCheck controller");
        return service.gameCheck(id);
    }
    @RequestMapping(value = "/updatePass", method = RequestMethod.POST)
    public Boolean updatePass(@RequestBody Administrator admin){
        System.out.println("updatePass controller");
        return service.updatePass(admin);
    }

}
