package com.xust.controller;

import com.xust.dao.ParamSettingPo;
import com.xust.service.SettingService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ParamSettingPo> getParamSetting(){
       return settingService.getParamSetting();
    }

    @PostMapping(value = "/param")
    public void insetParamSetting(String id , String name , int airIntake ,
                                  int airVelocity , int coalSeam , String geologicalStructure ,
                                  int designProductionCapacity , int verificationProductionCapacity){
        settingService.insertParamSetting(UUID.randomUUID().toString(), name, airIntake, airVelocity, coalSeam, geologicalStructure,
                designProductionCapacity, verificationProductionCapacity);
    }
}
