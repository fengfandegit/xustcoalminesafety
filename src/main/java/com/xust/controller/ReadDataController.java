package com.xust.controller;

import com.alibaba.fastjson.JSONObject;
import com.xust.service.ReadRunService;
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
    public JSONObject getData(@RequestParam("no") String no,
                              @RequestParam("type") String type,
                              @RequestParam("id") String id,
                              @RequestParam("starttime") String starttime,
                              @RequestParam("endtime") String endtime) {
        JSONObject jsonObject = new JSONObject();
        String[] realdatas = readRunService.getData(no, type, id, starttime, endtime);
        for (int i = 0; i < realdatas.length; i++) {
            String[] value = realdatas[i].split(":");
            jsonObject.put(value[0], value[1]);
        }
        return jsonObject;
    }

    @RequestMapping("/getnowdata")
    public JSONObject getData(@RequestParam("no") String no,
                              @RequestParam("type") String type,
                              @RequestParam("id") String id){
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }
}
