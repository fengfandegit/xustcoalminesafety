package com.xust.dao;


import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

/**
 * Created by lenovo on 2018/5/14.
 * @Test by fengfan
 */
@Mapper
public interface UserMapper {
    @Select("select * from user_test where name = #{name}")
    User findUserByName(@Param("name") String name);
}
