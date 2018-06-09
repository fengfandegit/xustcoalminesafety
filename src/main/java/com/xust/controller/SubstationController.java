package com.xust.controller;

import com.xust.dao.SubstationPo;
import com.xust.service.SubstationService;
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
@RequestMapping(value = "/substation")
@MapperScan(basePackages = "com.xust.dao")
public class SubstationController {
    @Autowired
    private SubstationService substationService;

    @GetMapping(value = "/info")
    public Object getSubstation(String callback){
        List<SubstationPo> substationPos = substationService.getSubstation();
        for (int i = 0; i < substationPos.size(); i++) {
            substationPos.get(i).setCallback(callback);
        }
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(substationPos);
        mappingJacksonValue.setJsonpFunction(callback);
        System.out.println("成功");
        return mappingJacksonValue;
    }

    @PostMapping(value = "/info1")
    public Object insertSubstation(SubstationPo substationPo){
        substationService.insertSubstation(UUID.randomUUID().toString(),substationPo.getNum(),substationPo.getPosition1(),substationPo.getType());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(substationPo);
        mappingJacksonValue.setJsonpFunction(substationPo.getCallback());
        System.out.println("成功");
        return mappingJacksonValue;
    }

    @PostMapping(value = "/info2")
    public Object updateSubstation(SubstationPo substationPo){
        substationService.updateSubstation(substationPo.getId(),substationPo.getNum(),substationPo.getPosition1(),substationPo.getType());
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(substationPo);
        mappingJacksonValue.setJsonpFunction(substationPo.getCallback());
        System.out.println("成功");
        return mappingJacksonValue;
    }

    @GetMapping(value = "/info3")
    public Object deleteSubstation(String callback,String id){
        substationService.deleteSubstation(id);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(new SubstationPo());
        mappingJacksonValue.setJsonpFunction(callback);
        System.out.println("成功");
        return mappingJacksonValue;
    }
}
