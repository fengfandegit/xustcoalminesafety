package com.xust.controller;

import com.xust.service.HistoryService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;


/**
 * Created by 10045 on 2018/5/22.
 */
@Controller
@RequestMapping(value = "/history")
@MapperScan(basePackages = "com.xust.dao")
public class HistoryController {
    @Autowired
    private HistoryService historyService;

    @PostMapping(value = "/param")
    public void insetHistoryData(MultipartFile file){
        historyService.insertHistoryData(file);
    }
}
