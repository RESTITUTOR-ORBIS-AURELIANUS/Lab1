package com.quantdev.lab1.mapper;

import com.quantdev.lab1.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface CounterMapper {

    @Select("SELECT `count` FROM lab1 LIMIT 1")
    Integer selectCount();

    @Update("UPDATE lab1 SET `count` = `count` + 1")
    int incrementCount();
}
