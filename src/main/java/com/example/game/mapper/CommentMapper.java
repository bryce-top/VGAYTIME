package com.example.game.mapper;
import com.example.game.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CommentMapper {
    public List<Comment> getGameComment(int game_id);
    public boolean insertComment(Comment comment);

}
