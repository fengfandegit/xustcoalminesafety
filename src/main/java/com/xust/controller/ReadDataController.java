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

import java.util.*;

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
    public Map<String,AverageDao[]> getData(@RequestParam("no") String no,
                                      @RequestParam("type") String type,
                                      @RequestParam("id") String id,
                                      @RequestParam("starttime") String starttime,
                                      @RequestParam("endtime") String endtime) {

        return readRunService.getData(no, type, id, starttime, endtime);
    }

    @RequestMapping("/getnowdata")
    public JSONObject getData(@RequestParam("no") String no,
                              @RequestParam("type") String type,
                              @RequestParam("id") String id) {
        JSONObject jsonObject = new JSONObject();

        return jsonObject;
    }
}
