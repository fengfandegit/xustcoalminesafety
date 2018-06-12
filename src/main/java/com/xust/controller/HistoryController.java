package com.xust.controller;

import com.xust.dao.AverageDao;
import com.xust.service.HistoryService;
import org.apache.ibatis.annotations.Param;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.http.HttpRequest;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

/**
 * Created by 10045 on 2018/5/22.
 */

@Controller
@RequestMapping(value = "/history")
@MapperScan(basePackages = "com.xust.dao")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

  /*  @PostMapping("/param2")*/
  @RequestMapping(value = "/param2",consumes = "multipart/form-data",method = RequestMethod.POST)
    public String insetHistoryData(@RequestParam("file") MultipartFile file){
        System.out.println("entern");
        historyService.insertHistoryData(file);
/*        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(file);
        mappingJacksonValue.setJsonpFunction(callback);
        System.out.println("success11");
        return mappingJacksonValue;*/
      return "redirect:http://127.0.0.1:8020/graduaProject/yanse.html?__hbt=1528629329217#1";
    }

/*    *//**
     * 按条件获取历史数据
     * @param no
     * @param type
     * @param id
     * @param starttime
     * @param endtime
     * @return
     *//*
    @RequestMapping(value = "/param")
    public Map<String,AverageDao[]> listHistory(@RequestParam("no") String no,
                                                @RequestParam("type") String type,
                                                @RequestParam("id") String id,
                                                @RequestParam("starttime") String starttime,
                                                @RequestParam("endtime") String endtime){
        return historyService.listHistory(no,type,id,starttime,endtime);
    }*/

    /**
     * 获取预测数据
     * @param no
     * @param type
     * @param id
     * @param starttime
     * @param endtime
     * @return
     */
    @GetMapping(value = "/param1")
    public Map<String,AverageDao[]> list(String no, String type, String id, String starttime, String endtime){
        return historyService.listpreHistory(no,type,id,starttime,endtime);
    }
}
