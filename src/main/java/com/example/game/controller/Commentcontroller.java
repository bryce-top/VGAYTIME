package com.example.game.controller;
import com.example.game.service.CommentService;
import org.apache.ibatis.annotations.Param;
import javax.annotation.Resource;
import com.example.game.entity.Comment;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "/do/comment")
public class Commentcontroller {
    @Resource
    private CommentService service;
    @GetMapping("/getGameComment")
    public List<Comment> getGameComment(int page,int page_size,int game_id){
        System.out.println("getcommentControl");
        List<Comment> list= service.getGameComment(page, page_size, game_id);
        return list;
    }
    @PostMapping("/insertGameComment")
    public boolean insertGameComment(@RequestBody Comment comment){
        System.out.println("insertGameCommentControl");
        System.out.println(comment.getContent());
        return service.insertComment(comment);
    }
    @GetMapping("/getTotal")
    public int getTotal(String game_id){
        return service.getTotal(game_id);
    }
    @GetMapping("/addStar")
    public boolean addStar( int id){
        System.out.println("addStarControl");
        return service.addStar(id);
    }
}
