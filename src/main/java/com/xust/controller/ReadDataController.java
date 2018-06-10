package com.xust.controller;

import com.alibaba.fastjson.JSONObject;
import com.xust.dao.AverageDao;
import com.xust.service.ReadRunService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
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
        Map<String,AverageDao[]>  map = readRunService.getData(no, type, id, starttime, endtime);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(map);
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }

    @RequestMapping("/getnowdata")
    public Object getData(@RequestParam("no") String no,
                              @RequestParam("type") String type,
                              @RequestParam("id") String id,
                              @RequestParam("callback")String callback) {
        Date d = new Date(System.currentTimeMillis());
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
        String valuem = sdf.format(d);
        MappingJacksonValue mappingJacksonValue = new MappingJacksonValue(readRunService.getNowDatas(no,type,id,valuem));
        mappingJacksonValue.setJsonpFunction(callback);
        return mappingJacksonValue;
    }
}
