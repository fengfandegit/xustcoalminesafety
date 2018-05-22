package com.xust.controller;


import com.xust.service.Userservice;
import com.xust.utils.AlarmMessageAPI;
import com.xust.utils.MessageInfo;
import com.xust.utils.TenMessageAPI;
import com.xust.utils.message.api.MessageAPI;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * Created by lenovo on 2018/5/14.
 */
@Controller
@RequestMapping(value = "/application")
@MapperScan(basePackages = "com.xust.dao")
public class MianController {

    @RequestMapping(value = "/message")
    public void index(@RequestParam("model") String model, @RequestParam("phonenum") String phonenum) {
        //0是验证码、1是报警
        MessageAPI messageAPI = null;
        if (model.equals("0")) {
            messageAPI = new TenMessageAPI();
        } else if (model.equals("1")) {
            messageAPI = new AlarmMessageAPI();
        }
        messageAPI.sendVerificationCode(MessageInfo.appid, MessageInfo.appkey, phonenum, MessageInfo.Verification_Code_TemplateId
                , MessageInfo.smsSign);
    }


    @Autowired
    Userservice userservice;

    @RequestMapping(value = "/login")
    public String login(@RequestParam("phonenum") String phonenum, @RequestParam("password") String password) {
        if (userservice.checkLogin(phonenum, password)) {
            return "redirect:/index.html";
        } else {
            return "redirect:/signup.html";
        }
    }
}
