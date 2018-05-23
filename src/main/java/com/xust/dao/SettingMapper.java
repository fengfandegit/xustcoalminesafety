package com.xust.dao;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 10045 on 2018/5/22.
 */
@Component(value = "settingMapper")
@Mapper
public interface SettingMapper {
    @Select("select id as id," +
            "name as name," +
            "air_intake as airIntake," +
            "air_velocity as airVelocity," +
            "coal_seam as coalSeam," +
            "geological_structure as geologicalStructure," +
            "design_production_capacity as designProductionCapacity," +
            "verification_production_capacity as verificationProductionCapacity from parameter_setting")
    public abstract List<ParamSettingPo> findParamSetting() throws Exception;

    @Insert("INSERT INTO parameter_setting(id,name,air_intake,air_velocity,coal_seam,geological_structure,design_production_capacity,verification_production_capacity) VALUES(" +
            "#{id},#{name},#{airIntake},#{airVelocity},#{coalSeam},#{geologicalStructure},#{designProductionCapacity},#{verificationProductionCapacity})")
    public abstract void insertParamSetting(@Param("id") String id, @Param("name") String name, @Param("airIntake") int airIntake,
                                    @Param("airVelocity") int airVelocity, @Param("coalSeam") int coalSeam, @Param("geologicalStructure") String geologicalStructure,
                                    @Param("designProductionCapacity") int designProductionCapacity, @Param("verificationProductionCapacity") int verificationProductionCapacity);

}
