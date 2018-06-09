package com.xust.controller;

import com.alibaba.fastjson.JSONObject;
import com.xust.dao.AverageDao;
import com.xust.service.ReadRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

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

    /*@PostMapping("/gethistorydata")*/
    @RequestMapping("/gethistorydata")
    public Object getData(@RequestParam("callback")String callback,
                                            @RequestParam("no") String no,
                                      @RequestParam("type") String type,
                                      @RequestParam("id") String id,
                                      @RequestParam("starttime") String starttime,
                                      @RequestParam("endtime") String endtime) {
        System.out.println("ssssssssssssssssssssss");
        Map<String,AverageDao[]>  map = readRunService.getData(no, type, id, starttime, endtime);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(map);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

    @RequestMapping("/getnowdata")
    public JSONObject getData(@RequestParam("no") String no,
                              @RequestParam("type") String type,
                              @RequestParam("id") String id) {
        JSONObject jsonObject = new JSONObject();
        return jsonObject;
    }
}
