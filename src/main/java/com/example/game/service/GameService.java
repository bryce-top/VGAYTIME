package com.example.game.service;
import com.example.game.entity.Game;
import com.example.game.entity.User;
import com.example.game.mapper.GameMapper;
import com.example.game.mapper.UserMapper;
import com.sun.org.apache.bcel.internal.generic.NEW;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sun.awt.geom.AreaOp;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;
@Service
public class GameService {
    @Resource
    private GameMapper mapper;
    public List<Game> getAllGame(){
        System.out.println("进入GameService");
        List<Game> list= new ArrayList<Game>();
        list=mapper.selectAll();
        return list;
    }
    public List<Game> findGamebytype(String type){
        System.out.println("进入findGamebytypeService");
        List<Game> list=new ArrayList<Game>();
        list=mapper.findGamebytype(type);
        return list;
    }
    public List<Game> findGamebyname(String name){
        System.out.println("进入findGamebyname");
        List<Game> list=new ArrayList<Game>();
        list=mapper.findGamebyname(name);
        return list;
    }
    public Boolean insertGame(Game game){
        System.out.println("insertGameService");
        if (mapper.insertGame(game))
            return true;
        else return false;
    }
    public List<Game> findGamebyid(String id){
        List<Game> list=new ArrayList<Game>();
        System.out.println("findGamebyidService");
        list=mapper.findGamebyid(id);
        return list;
    }
}
