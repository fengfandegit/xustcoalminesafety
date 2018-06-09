package com.xust.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 10045 on 2018/5/28.
 */
@Component(value = "substationMapper")
@Mapper
public interface SubstationMapper {
    @Select("select * from substation order by num")
    public List<SubstationPo> getSubstation();
    @Insert("insert into substation(id,num,position1,type) values (#{id},#{num},#{position1},#{type})")
    public void insertSubstation(@Param("id") String id,@Param("num") int num,@Param("position1") String position1,@Param("type") String type);
    @Update("update substation set num = #{num},position1 = #{position1},type = #{type} where id = #{id}")
    public void updateSubstation(@Param("num") int num,@Param("position1") String position1,@Param("type") String type,@Param("id") String id);
    @Delete("delete from substation where id = #{id}")
    public void deleteSubstation(@Param("id") String id);
}
