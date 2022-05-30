package com.example.game.mapper;
import com.example.game.entity.Comment;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface CommentMapper {
    public List<Comment> getGameComment(@Param("fo")int fo,@Param("to")int to,@Param("game_id") int game_id);
    public boolean insertComment(@Param("comment") Comment comment);
    public int getTotal(@Param("game_id") String game_id);
}
