package com.xust.service;

import com.xust.dao.SubstationMapper;
import com.xust.dao.SubstationPo;
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
public class SubstationService {
    @Autowired
    private SubstationMapper substationMapper;

    public List<SubstationPo> getSubstation(){
        return substationMapper.getSubstation();
    }
    public void insertSubstation(String id,int num,String position1,String type){
        substationMapper.insertSubstation(id,num,position1,type);
    }
    public void updateSubstation(String id,int num,String position1,String type){
        substationMapper.updateSubstation(num,position1,type,id);
    }
    public void deleteSubstation(String id){
        substationMapper.deleteSubstation(id);
    }
}
