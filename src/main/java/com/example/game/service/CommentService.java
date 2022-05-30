package com.example.game.service;
import com.example.game.entity.Comment;
import com.example.game.entity.Game;
import com.example.game.mapper.CommentMapper;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {
    @Resource
    private CommentMapper mapper;
    public List<Comment> getGameComment(int page,int page_size,int game_id){
        System.out.println("进入getGameCommentService");
        List<Comment> list=new ArrayList<Comment>();
        int fo=page*page_size;
        int to=page_size;
        list= mapper.getGameComment(fo,to,game_id);

        return list;
    }
    public boolean insertComment(Comment comment){
        System.out.println("进入insertCommentService");
        if(mapper.insertComment(comment)){
            return true;
        }else return false;
    }
    public int getTotal(String id){
        return mapper.getTotal(id);
    }
    public boolean deleteComment(int id){
        System.out.println("进入delete comment Service");
        mapper.deleteComment(id);
        return true;
    }
}
