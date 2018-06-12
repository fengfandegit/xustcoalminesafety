package com.xust.controller;

import com.xust.dao.SensorPo;
import com.xust.service.SensorService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

/**
 * Created by 10045 on 2018/5/28.
 */
@RestController
@RequestMapping(value = "/sensor")
@MapperScan(basePackages = "com.xust.dao")
public class SensorController {
    @Autowired
    private SensorService sensorService;

    @GetMapping(value = "/info")
    @ResponseBody
    public Object getSensor(String callback){
        List<SensorPo> sensorPoList = sensorService.getSensor();
        for (int i = 0; i < sensorPoList.size(); i++) {
            sensorPoList.get(i).setCallback(callback);
        }
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sensorPoList);
        mappingJacksonValue.setJsonpFunction(callback);
        System.out.println("success11");
        return mappingJacksonValue;
    }

    @GetMapping(value = "/info1")
    @ResponseBody
    public Object insertSensor(SensorPo sensorPo){
        sensorService.insertSensor(UUID.randomUUID().toString(),
                sensorPo.getNum(),sensorPo.getName(),sensorPo.getModel(),
                sensorPo.getType(),sensorPo.getUnit());
        System.out.println("success21");
        sensorPo.setCallback(sensorPo.getCallback());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sensorPo);
        mappingJacksonValue.setJsonpFunction(sensorPo.getCallback());
        System.out.println("成功");
        return mappingJacksonValue;
    }

    @GetMapping(value = "/info2")
    @ResponseBody
    public Object updateSensor(String callback,SensorPo sensorPo){
        sensorPo.setCallback(callback);
        sensorService.updateSensor(sensorPo.getId(),sensorPo.getNum(),
                sensorPo.getName(),sensorPo.getModel(),
                sensorPo.getType(),sensorPo.getUnit());
        System.out.println("success23");
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sensorPo);
        mappingJacksonValue.setJsonpFunction(sensorPo.getCallback());
        System.out.println("成功");
        return mappingJacksonValue;
    }
    @GetMapping(value = "/info3")
    @ResponseBody
    public Object deleteSensor(String callback,String id){
        sensorService.deleteSensor(id);
        System.out.println("success33");
        SensorPo sensorPo = new SensorPo();
        sensorPo.setCallback(callback);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(sensorPo);
        mappingJacksonValue.setJsonpFunction(sensorPo.getCallback());
        System.out.println("成功");
        return mappingJacksonValue;
    }
}
