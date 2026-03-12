package com.quantdev.lab1.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface CounterMapper {

    @Select("SELECT `count` FROM lab1 LIMIT 1")
    Integer selectCount();

    @Update("UPDATE lab1 SET `count` = `count` + 1")
    int incrementCount();
}
