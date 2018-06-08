package com.xust.service;

import com.xust.dao.SensorMapper;
import com.xust.dao.SensorPo;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 10045 on 2018/5/28.
 */
@Service
@MapperScan("com.xust.dao")
@ComponentScan(basePackages = {"com.xust.dao"})
public class SensorService {
    @Autowired
    private SensorMapper sensorMapper;

    public List<SensorPo> getSensor(){
        return sensorMapper.getSensor();
    }

    public void insertSensor(String id,int num,String name,String model,String type,String unit){
        sensorMapper.insertSensor(id,num,name,model,type,unit);
    }
    public void updateSensor(String id,int num,String name,String model,String type,String unit){
        sensorMapper.updateSensor(id,num,name,model,type,unit);
    }
    public void deleteSensor(String id){
        sensorMapper.deleteSensor(id);
    }
}
