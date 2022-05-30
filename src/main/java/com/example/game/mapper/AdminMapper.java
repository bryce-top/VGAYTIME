package com.example.game.mapper;

import com.example.game.entity.Administrator;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface AdminMapper {
    public Administrator findPassword(@Param("email") String email);
    public void updatePass(@Param("email") String email , @Param("newpass") String newpass);
    public int totalUncheck();
}

