package com.xust.controller;

import com.xust.dao.ParamSettingPo;
import com.xust.service.SettingService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by 10045 on 2018/5/22.
 */
@RestController
@RequestMapping(value = "/setting")
@MapperScan(basePackages = "com.xust.dao")
public class SettingController {

    @Autowired
    private SettingService settingService;

    @GetMapping(value = "/param")
    @ResponseBody
    public Object getParamSetting(String callback){
       ParamSettingPo paramSettingPo = settingService.getParamSetting();
       paramSettingPo.setCallback(callback);
       MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(paramSettingPo);
       mappingJacksonValue.setJsonpFunction(callback);
        System.out.println("success");
       return mappingJacksonValue;
    }

    @PostMapping(value = "/param2")
    public void insetParamSetting(String callback,String id , String name , int airIntake ,
                                  int airVelocity , int coalSeam , String geologicalStructure ,
                                  int designProductionCapacity , int verificationProductionCapacity,
                                  double wasixiangduiyongchuliang,
                                  double meicengyuanshiwasihanliang,
                                  double wasifangsanchusudu,
                                  double meicengtouqixingxishu,
                                  double wasijueduiyongchuliang,
                                  double meicengyuanshiwasiyali,
                                  double meicengpohuaileixing){
        System.out.println("success1");
        settingService.insertParamSetting(UUID.randomUUID().toString(), name, airIntake, airVelocity, coalSeam, geologicalStructure,
                designProductionCapacity, verificationProductionCapacity, wasixiangduiyongchuliang, meicengyuanshiwasihanliang,
                wasifangsanchusudu, meicengtouqixingxishu, wasijueduiyongchuliang, meicengyuanshiwasiyali, meicengpohuaileixing);
    }

    @GetMapping(value = "/param3")
    @ResponseBody
    public Object updateParamSetting(String callback,String id , String name , int air_intake ,
                                   int air_velocity , int coal_seam , String geological_structure ,
                                   int design_production_capacity , int verification_production_capacity,
                                   double wasixiangduiyongchuliang,
                                   double meicengyuanshiwasihanliang,
                                   double wasifangsanchusudu,
                                   double meicengtouqixingxishu,
                                   double wasijueduiyongchuliang,
                                   double meicengyuanshiwasiyali,
                                   double meicengpohuaileixing){
        System.out.println("success2");
        settingService.updateParamSetting(id, name, air_intake, air_velocity, coal_seam, geological_structure,
                design_production_capacity, verification_production_capacity, wasixiangduiyongchuliang, meicengyuanshiwasihanliang,
                wasifangsanchusudu, meicengtouqixingxishu, wasijueduiyongchuliang, meicengyuanshiwasiyali, meicengpohuaileixing);
        ParamSettingPo paramSettingPo = new ParamSettingPo();
        paramSettingPo.setCallback(callback);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(paramSettingPo);
        mappingJacksonValue.setJsonpFunction(callback);
        System.out.println("success22");
        return mappingJacksonValue;
    }
}
