package com.xust.service;

import com.xust.dao.ParamSettingPo;
import com.xust.dao.SettingMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10045 on 2018/5/22.
 */
@Service
@MapperScan("com.xust.dao")
@ComponentScan(basePackages={"com.xust.dao"})
public class SettingService {
    @Autowired
    private SettingMapper settingMapper;

    public List<ParamSettingPo> getParamSetting(){
        List<ParamSettingPo> paramSettingPo = new ArrayList<>();
        try {
            paramSettingPo = settingMapper.findParamSetting();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paramSettingPo;
    }

    public void insertParamSetting(String id , String name , int airIntake ,
                                   int airVelocity , int coalSeam , String geologicalStructure ,
                                   int designProductionCapacity , int verificationProductionCapacity){
        settingMapper.insertParamSetting(id, name, airIntake, airVelocity, coalSeam, geologicalStructure,
                designProductionCapacity, verificationProductionCapacity);
    }
}
