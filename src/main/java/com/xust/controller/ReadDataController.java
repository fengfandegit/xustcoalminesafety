package com.xust.controller;

import com.alibaba.fastjson.JSONObject;
import com.xust.dao.AverageDao;
import com.xust.service.ReadRunService;
import com.xust.utils.AverageUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/5/30.
 */
@RestController
@CrossOrigin
@RequestMapping(value = "/readdata")
public class ReadDataController {
    @Autowired
    ReadRunService readRunService;

    @RequestMapping("/gethistorydata")
    public AverageDao[] getData(@RequestParam("no") String no,
                              @RequestParam("type") String type,
                              @RequestParam("id") String id,
                              @RequestParam("starttime") String starttime,
                              @RequestParam("endtime") String endtime) {
        //JSONObject jsonObject = new JSONObject();
        String[] realdatas = readRunService.getData(no, type, id, starttime, endtime);
      /*  for (int i = 0;i<realdatas.length;i++){
            System.out.println(realdatas[i]);
        }*/
        AverageDao[] abstractDaos = new AverageUtil().getAverage(realdatas[0].split(":")[1].split(","), 0.90);
        int newlen = 0;
        for(int i = 0;i<abstractDaos.length;i++){
            if (abstractDaos[i]!=null){
                newlen++;
            }
        }
        AverageDao[] realDaos = new AverageDao[newlen];
        int temp = 0;
        for (int i = 0;i<abstractDaos.length;i++){
            if (abstractDaos[i]!=null){
                realDaos[temp++] = abstractDaos[i];
            }
        }
        return realDaos;
    }

    @RequestMapping("/getnowdata")
    public JSONObject getData(@RequestParam("no") String no,
                              @RequestParam("type") String type,
                              @RequestParam("id") String id){
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }
}
