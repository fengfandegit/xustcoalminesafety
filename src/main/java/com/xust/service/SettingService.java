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

    public ParamSettingPo getParamSetting(){
        ParamSettingPo paramSettingPo = new ParamSettingPo();
        try {
            paramSettingPo = settingMapper.findParamSetting();
        }catch (Exception e){
            e.printStackTrace();
        }
        return paramSettingPo;
    }

    public void insertParamSetting(String id , String name , int airIntake ,
                                   int airVelocity , int coalSeam , String geologicalStructure ,
                                   int designProductionCapacity , int verificationProductionCapacity,
                                   double wasixiangduiyongchuliang,
                                   double meicengyuanshiwasihanliang,
                                   double wasifangsanchusudu,
                                   double meicengtouqixingxishu,
                                   double wasijueduiyongchuliang,
                                   double meicengyuanshiwasiyali,
                                   double meicengpohuaileixing){
        settingMapper.insertParamSetting(id, name, airIntake, airVelocity, coalSeam, geologicalStructure,
                designProductionCapacity, verificationProductionCapacity, wasixiangduiyongchuliang, meicengyuanshiwasihanliang,
        wasifangsanchusudu, meicengtouqixingxishu, wasijueduiyongchuliang, meicengyuanshiwasiyali, meicengpohuaileixing);
    }

    public void updateParamSetting(String id , String name , int airIntake ,
                                   int airVelocity , int coalSeam , String geologicalStructure ,
                                   int designProductionCapacity , int verificationProductionCapacity,
                                   double wasixiangduiyongchuliang,
                                   double meicengyuanshiwasihanliang,
                                   double wasifangsanchusudu,
                                   double meicengtouqixingxishu,
                                   double wasijueduiyongchuliang,
                                   double meicengyuanshiwasiyali,
                                   double meicengpohuaileixing){
        settingMapper.updateParamSetting(id, name, airIntake, airVelocity, coalSeam, geologicalStructure,
                designProductionCapacity, verificationProductionCapacity, wasixiangduiyongchuliang, meicengyuanshiwasihanliang,
                wasifangsanchusudu, meicengtouqixingxishu, wasijueduiyongchuliang, meicengyuanshiwasiyali, meicengpohuaileixing);
    }
}
