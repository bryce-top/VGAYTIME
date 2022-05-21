package com.example.game.service;
import com.example.game.entity.Comment;
import com.example.game.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    private CommentMapper mapper;
    public List<Comment> getGameComment(int game_id){
        List<Comment> list=new ArrayList<Comment>();
        list= mapper.getGameComment(game_id);
        return list;
    }
    public boolean insertComment(Comment comment){
        if(mapper.insertComment(comment)){
            return true;
        }else return false;
    }
}
