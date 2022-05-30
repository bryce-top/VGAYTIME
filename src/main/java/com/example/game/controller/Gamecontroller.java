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
    public List<Game> findGamebyname(int page,int page_size,String name){
        List<Game> list=new ArrayList<Game>();
        System.out.println("page :"+page+"    pagesize :"+page_size+"    game :"+name);
        list=service.findGamebyname(page,page_size,name);
        return list;
    }
    @PostMapping("/insertGame")
    public Boolean inserGame(@RequestBody Game game){

        return service.insertGame(game);
    }
    @GetMapping("/findGamebyid")
    public List<Game> findGamebyid(@RequestParam("id") String id){
        List<Game> list=new ArrayList<Game>();
        System.out.println(id);
        list=service.findGamebyid(id);
        return list;
    }
    @GetMapping("/findTotal")
    public int findTotal(@RequestParam("name")String name){
        System.out.println(name);
        return service.findTotal(name);
    }
    @RequestMapping("/uncheckGame")
    public List<Game> uncheckGame(){
        List<Game> list=new ArrayList<Game>();
        list=service.uncheckGame();
        return list;
    }
    @PostMapping("/deleteGame")
    public boolean deleteUser(@RequestBody Game game){
        return service.deleteGame(game);
    }
    @PostMapping("/updateGame")
    public boolean updateGame(@RequestBody Game game){
        return service.updateGame(game);
    }



}
