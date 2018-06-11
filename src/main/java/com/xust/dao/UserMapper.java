package com.xust.dao;


import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/5/14.
 *
 * @Test by fengfan
 *//*
@Mapper*/
 @Component(value = "userMapper")
@Mapper
public interface UserMapper {

    @Select("select * from users where phonenum = #{phonenum}")
    ArrayList<User> findUserByName(@Param("phonenum") String phonenum) throws Exception;

    @Insert("INSERT INTO users(id,phonenum,password,realname,workid,power,groupid,salt) VALUES(" +
            "#{id},#{phonenum},#{password},#{realname},#{workid},#{power},#{groupid},#{salt})")
    void insertInfo(@Param("id") String id, @Param("phonenum") String phonenum, @Param("password") String password,
                                    @Param("realname") String realname, @Param("workid") String workid, @Param("power") int power,
                                    @Param("groupid") String groupid, @Param("salt") String salt);
}
