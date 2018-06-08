package com.xust.dao;

import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by 10045 on 2018/5/22.
 */
@Component(value = "settingMapper")
@Mapper
public interface SettingMapper {
    @Select("select * from parameter_setting limit 1")
    public abstract ParamSettingPo findParamSetting() throws Exception;

    @Insert("INSERT INTO parameter_setting(id,name,air_intake,air_velocity,coal_seam,geological_structure,design_production_capacity,verification_production_capacity," +
            "wasixiangduiyongchuliang,meicengyuanshiwasihanliang,wasifangsanchusudu,meicengtouqixingxishu," +
            "wasijueduiyongchuliang,meicengyuanshiwasiyali,meicengpohuaileixing) VALUES(" +
            "#{id},#{name},#{air_intake},#{air_velocity},#{coal_seam},#{geological_structure},#{design_production_capacity},#{verification_production_capacity}," +
            "#{wasixiangduiyongchuliang},#{meicengyuanshiwasihanliang},#{wasifangsanchusudu}," +
            "{meicengtouqixingxishu},#{wasijueduiyongchuliang},#{meicengyuanshiwasiyali},#{meicengpohuaileixing})")
    public abstract void insertParamSetting(@Param("id") String id, @Param("name") String name, @Param("air_intake") int air_intake,
                                            @Param("air_velocity") int air_velocity, @Param("coal_seam") int coal_seam, @Param("geological_structure") String geological_structure,
                                            @Param("design_production_capacity") int design_production_capacity, @Param("verification_production_capacity") int verification_production_capacity,
                                            @Param("wasixiangduiyongchuliang") double wasixiangduiyongchuliang,@Param("meicengyuanshiwasihanliang") double meicengyuanshiwasihanliang,
                                            @Param("wasifangsanchusudu") double wasifangsanchusudu,@Param("meicengtouqixingxishu") double meicengtouqixingxishu,
                                            @Param("wasijueduiyongchuliang") double wasijueduiyongchuliang,@Param("meicengyuanshiwasiyali") double meicengyuanshiwasiyali,
                                            @Param("meicengpohuaileixing") double meicengpohuaileixing);
    @Update("update parameter_setting set name = #{name},air_intake = #{air_intake},air_velocity = #{air_velocity}," +
            "coal_seam = #{coal_seam},geological_structure = #{geological_structure},design_production_capacity = #{design_production_capacity}," +
            "verification_production_capacity = #{verification_production_capacity},wasixiangduiyongchuliang = #{wasixiangduiyongchuliang}," +
            "meicengyuanshiwasihanliang = #{meicengyuanshiwasihanliang},wasifangsanchusudu = #{wasifangsanchusudu},meicengtouqixingxishu = #{meicengtouqixingxishu}," +
            "wasijueduiyongchuliang = #{wasijueduiyongchuliang},meicengyuanshiwasiyali = #{meicengyuanshiwasiyali}," +
            "meicengpohuaileixing = #{meicengpohuaileixing} where id = #{id}")
    public abstract void updateParamSetting(@Param("id") String id, @Param("name") String name, @Param("air_intake") int air_intake,
                                            @Param("air_velocity") int air_velocity, @Param("coal_seam") int coal_seam, @Param("geological_structure") String geological_structure,
                                            @Param("design_production_capacity") int design_production_capacity, @Param("verification_production_capacity") int verification_production_capacity,
                                            @Param("wasixiangduiyongchuliang") double wasixiangduiyongchuliang,@Param("meicengyuanshiwasihanliang") double meicengyuanshiwasihanliang,
                                            @Param("wasifangsanchusudu") double wasifangsanchusudu,@Param("meicengtouqixingxishu") double meicengtouqixingxishu,
                                            @Param("wasijueduiyongchuliang") double wasijueduiyongchuliang,@Param("meicengyuanshiwasiyali") double meicengyuanshiwasiyali,
                                            @Param("meicengpohuaileixing") double meicengpohuaileixing);

}
