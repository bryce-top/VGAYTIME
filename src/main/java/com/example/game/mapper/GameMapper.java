package com.example.game.mapper;
import com.example.game.entity.Game;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
@Mapper
public interface GameMapper {
    public List<Game> selectAll();
    public List<Game> findGamebytype(@Param("type")String type);
    public List<Game> findGamebyname(@Param("fo")int fo,@Param("to")int to,@Param("name")String name);
    public Boolean insertGame(@Param("game")Game game);
    public List<Game> findGamebyid(@Param("id")String id);
    public Game check(@Param("id") int id);
    public int findTotal(@Param("name")String name);
}
