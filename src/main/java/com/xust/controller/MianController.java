package com.xust.controller;

import com.xust.service.Userservice;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by lenovo on 2018/5/14.
 */
@Controller
@RequestMapping(value = "/application")
@MapperScan(basePackages = "com.xust.dao"/*,sqlSessionFactoryRef = "SqlSessionFactory"*/)
public class MianController {

    @RequestMapping(value = "/two")
    public String index() {
        return "redirect:/index.html";
    }

    @Autowired
    Userservice userservice;

    @RequestMapping(value = "/login" )
    public String login(@RequestParam("phonenum")String phonenum,@RequestParam("password")String password) {
        if (userservice.checkLogin(phonenum,password)){
            return "redirect:/index.html";
        }else {
            return "redirect:/signup.html";
        }

    }

}
