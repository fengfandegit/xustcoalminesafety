package com.xust.controller;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by lenovo on 2018/5/14.
 */
@RestController
@SpringBootApplication
@EnableAutoConfiguration
@RequestMapping(value = "/application")
public class MianController {
    @RequestMapping(value = "/two", produces = "text/plain;charset=UTF-8")
    public String index(@RequestParam("name") String name) {
        return "Hello Spring Boot TWO" + name;
    }

}
