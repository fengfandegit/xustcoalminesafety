package com.xust.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Component;

/**
 * Created by 10045 on 2018/5/27.
 */
@Component(value = "judgeMapper")
@Mapper
public interface JudgeMapper {
    @Select("select * from borehole_information LIMIT 1")
    public ConfigurationPo getinfo();
    @Update("update borehole_information set diameter = #{diameter},spacing = #{spacing}," +
            "coordinate = #{coordinate},position2 = #{position2},angle = #{angle},depth = #{depth}")
    public void updateWorkInfo1(@Param("diameter") Double diameter, @Param("spacing") Double spacing, @Param("coordinate") String coordinate,
                               @Param("position2") String position2, @Param("angle") int angle, @Param("depth") double depth);
    @Update("update borehole_information set extraction_rate = #{extraction_rate}," +
            "extraction_num = #{extraction_num},time = #{time}")
    public void updateWorkInfo2(@Param("extraction_rate") Double extraction_rate,@Param("extraction_num") Double extraction_num,@Param("time") Integer time);
    @Update("update borehole_information set concentration_assessment = #{concentration_assessment}," +
            "extraction_rate_assessment = #{extraction_rate_assessment}," +
            "extraction_num_assessment = #{extraction_num_assessment}," +
            "comprehensive_evaluation = #{comprehensive_evaluation}")
    public void updateWorkInfo3(@Param("concentration_assessment") Double concentration_assessment,@Param("extraction_rate_assessment") Double extraction_rate_assessment,
                               @Param("extraction_num_assessment") Double extraction_num_assessment,@Param("comprehensive_evaluation") int comprehensive_evaluation);
    @Update("update borehole_information set add_press = #{add_press}," +
            "add_time = #{add_time},add_radius = #{add_radius},add_power = #{add_power}," +
            "distance = #{distance},wind_num = #{wind_num}")
    public void updateWorkInfo4(@Param("add_press") Double add_press,@Param("add_time") int add_time,@Param("add_radius") Double add_radius,@Param("add_power") Double add_power,
                               @Param("distance") Double distance,@Param("wind_num") Double wind_num);
}
