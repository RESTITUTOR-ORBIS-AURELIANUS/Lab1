package com.quantdev.lab1.mapper;

import com.quantdev.lab1.entity.User;
import org.apache.ibatis.annotations.*;

@Mapper
public interface UserMapper {
    @Insert("INSERT INTO User (userName,passWord) values (#{userName},#{passWord})")
    @Options(useGeneratedKeys = true,keyProperty = "id")
    int insertUser(User user);

    @Select("SELECT id,userName,passWord FROM User where userName=#{userName} LIMIT 1")
    User getUser(@Param("userName")String userName);

    @Select("SELECT COUNT(*) FROM User WHERE userName=${userName}")
    int checkIsExisted(@Param("userName") String userName);
}
