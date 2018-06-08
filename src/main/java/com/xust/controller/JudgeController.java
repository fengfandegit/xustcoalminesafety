package com.xust.controller;

import com.xust.dao.ConfigurationPo;
import com.xust.service.JudgeService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 10045 on 2018/5/27.
 */
@RestController
@RequestMapping(value = "/judge")
@MapperScan(basePackages = "com.xust.dao")
public class JudgeController {
    @Autowired
    private JudgeService judgeService;

    @GetMapping(value = "/info")
    public Object getInfo(String callback){
        ConfigurationPo configurationPo = judgeService.getinfo();
        configurationPo.setCallback(callback);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(configurationPo);
        mappingJacksonValue.setJsonpFunction(callback);
        System.out.println("success11");
        return mappingJacksonValue;
    }

    /**
     *智能评判四大功能
     */
    @GetMapping(value = "/info1")
    public Object updateInfo(ConfigurationPo configurationPo){
        judgeService.updateInfo(configurationPo);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(configurationPo);
        mappingJacksonValue.setJsonpFunction(configurationPo.getCallback());
        System.out.println("success11");
        return mappingJacksonValue;
    }
}
