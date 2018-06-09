package com.xust.service;

import com.xust.dao.ConfigurationPo;
import com.xust.dao.JudgeMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by 10045 on 2018/5/27.
 */
@Service
@MapperScan("com.xust.dao")
@ComponentScan(basePackages = {"com.xust.dao"})
public class JudgeService {
    @Autowired
    private JudgeMapper judgeMapper;

    public ConfigurationPo getinfo() {
        return judgeMapper.getinfo();
    }

    @Transactional
    public void updateInfo(ConfigurationPo configurationPo) {
        /**
         * 修改钻孔施工信息
         */
        if (configurationPo.getDiameter() != null &&
                configurationPo.getExtraction_rate() == null &&
                configurationPo.getConcentration_assessment() == null &&
                configurationPo.getAdd_press() == null) {
            judgeMapper.updateWorkInfo1(configurationPo.getDiameter(),
                    configurationPo.getSpacing(),
                    configurationPo.getCoordinate(),
                    configurationPo.getPosition2(),
                    configurationPo.getAngle(),
                    configurationPo.getDepth());
            System.out.println("修改钻孔施工信息");
        }
        /**
         * 修改抽采计量数据
         */
        if (configurationPo.getDiameter() == null &&
                configurationPo.getExtraction_rate() != null &&
                configurationPo.getConcentration_assessment() == null &&
                configurationPo.getAdd_press() == null) {
            judgeMapper.updateWorkInfo2(configurationPo.getExtraction_rate(),
                    configurationPo.getExtraction_num(),
                    configurationPo.getTime());
            System.out.println("修改抽采计量数据");
        }
        /**
         * 修改抽采效果评估
         */
        if (configurationPo.getDiameter() == null &&
                configurationPo.getExtraction_rate() == null &&
                configurationPo.getConcentration_assessment() != null &&
                configurationPo.getAdd_press() == null) {
            judgeMapper.updateWorkInfo3(configurationPo.getConcentration_assessment(),
                    configurationPo.getExtraction_rate_assessment(),
                    configurationPo.getExtraction_num_assessment(),
                    configurationPo.getComprehensive_evaluation());
            System.out.println("修改抽采效果评估");
        }
        /**
         * 修改调控命令管理
         */
        if (configurationPo.getDiameter() == null &&
                configurationPo.getExtraction_rate() == null &&
                configurationPo.getConcentration_assessment() == null &&
                configurationPo.getAdd_press() != null) {
            judgeMapper.updateWorkInfo4(configurationPo.getAdd_press(),
                    configurationPo.getAdd_time(),
                    configurationPo.getAdd_radius(),
                    configurationPo.getAdd_power(),
                    configurationPo.getDistance(),
                    configurationPo.getWind_num());
            System.out.println("修改抽采效果评估");
        }
        /**
         * 三个修改依次进行
         */
        if (configurationPo.getDiameter() != null &&
                configurationPo.getExtraction_rate() != null &&
                configurationPo.getConcentration_assessment() != null &&
                configurationPo.getAdd_press() != null){
            judgeMapper.updateWorkInfo1(configurationPo.getDiameter(),
                    configurationPo.getSpacing(),
                    configurationPo.getCoordinate(),
                    configurationPo.getPosition2(),
                    configurationPo.getAngle(),
                    configurationPo.getDepth());
            System.out.println("修改钻孔施工信息");
            judgeMapper.updateWorkInfo2(configurationPo.getExtraction_rate(),
                    configurationPo.getExtraction_num(),
                    configurationPo.getTime());
            System.out.println("修改抽采计量数据");
            judgeMapper.updateWorkInfo4(configurationPo.getAdd_press(),
                    configurationPo.getAdd_time(),
                    configurationPo.getAdd_radius(),
                    configurationPo.getAdd_power(),
                    configurationPo.getDistance(),
                    configurationPo.getWind_num());
            System.out.println("修改抽采效果评估");
        }
    }
}
