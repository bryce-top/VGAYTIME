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
    public List<Comment> getGameComment(@RequestParam("game_id")int game_id){
        List<Comment> list= service.getGameComment(game_id);
        return list;
    }
    @PostMapping("/insertGameComment")
    public boolean insertGameComment(Comment comment){
        return service.insertComment(comment);
    }
}
