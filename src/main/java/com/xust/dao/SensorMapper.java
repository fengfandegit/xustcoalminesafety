package com.xust.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 10045 on 2018/5/28.
 */
@Component(value = "sensorMapper")
@Mapper
public interface SensorMapper {
    @Select("select * from sensor order by num")
    public List<SensorPo> getSensor();
    @Insert("insert into sensor (id,num,name,model,type,unit) values (#{id},#{num},#{name},#{model},#{type},#{unit})")
    public void insertSensor(@Param("id") String id,@Param("num") int num,@Param("name") String name,
                             @Param("model") String model,@Param("type") String type,@Param("unit") String unit);
    @Update("update sensor set num = #{num},name = #{name},model = #{model},type = #{type},unit = #{unit} where id = #{id}")
    public void updateSensor(@Param("id") String id,@Param("num") int num,@Param("name") String name,
                             @Param("model") String model,@Param("type") String type,@Param("unit") String unit);
    @Delete("delete from sensor where id = #{id}")
    public void deleteSensor(@Param("id") String id);
}
