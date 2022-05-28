package com.example.game.controller;
import com.example.game.entity.Game;
import com.example.game.entity.User;
import com.example.game.service.GameService;
import com.example.game.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
@RestController
@RequestMapping(value = "/do/game")
public class Gamecontroller {
    @Resource
    private GameService service;
    @RequestMapping("/AllGame")
    public List<Game> showAllGame(){
        List<Game> list=new ArrayList<Game>();
        list=service.getAllGame();
        return list;
    }
    @GetMapping("/findGamebytype")
    public List<Game> findGamebytype(@RequestParam("type")String type){
        List<Game> list=new ArrayList<Game>();
        list=service.findGamebytype(type);
        return list;
    }
    @GetMapping("/findGamebyname")
    public List<Game> findGamebyname(@RequestParam("name")String name){
        List<Game> list=new ArrayList<Game>();
        list=service.findGamebyname(name);
        return list;
    }
    @PostMapping("/insertGame")
    public Boolean inserGame(@Param("game")Game game){

        return service.insertGame(game);
    }
    @GetMapping("/findGamebyid")
    public List<Game> findGamebyid(@RequestParam("id") String id){
        List<Game> list=new ArrayList<Game>();
        System.out.println(id);
        list=service.findGamebyid(id);
        return list;
    }



}
