package com.xust.controller;


import com.alibaba.fastjson.JSONObject;
import com.xust.service.Userservice;
import com.xust.utils.AlarmMessageAPI;
import com.xust.utils.MessageInfo;
import com.xust.utils.TenMessageAPI;
import com.xust.utils.message.api.MessageAPI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


/**
 * Created by lenovo on 2018/5/14.
 */
@Controller
@CrossOrigin
@RequestMapping(value = "/application")
public class MianController {
    @Autowired
    Userservice userservice;

    @RequestMapping(value = "/message")
    @CrossOrigin
    public void index(@RequestParam("model") String model, @RequestParam("phonenum") String phonenum) {
        //0是验证码、1是报警
        MessageAPI messageAPI = null;
        int TempID = 0;
        if (model.equals("0")) {
            messageAPI = new TenMessageAPI();
            TempID = MessageInfo.Verification_Code_TemplateId;
        } else if (model.equals("1")) {
            messageAPI = new AlarmMessageAPI();
            TempID = MessageInfo.Alarm_Code_TemplateId;
        }
        messageAPI.sendVerificationCode(MessageInfo.appid, MessageInfo.appkey, phonenum, TempID, MessageInfo.smsSign);
    }

    @ResponseBody
    @CrossOrigin
    @RequestMapping(value = "/checkinsert")
    public JSONObject check(@RequestParam("realname") String realame,
                            @RequestParam("phonenum") String phonenum,
                            @RequestParam("password") String password,
                            @RequestParam("code") String code) {
        String flag;
        String phone = "0";
        //1表示注册过
        if (userservice.checkInsert(phonenum)) {
            phone = "1";
            flag = "0";
        } else if (code != null && !code.trim().equals("") && phonenum != null && !phonenum.trim().equals("")
                && new TenMessageAPI().checkVerificationCode(code, phonenum)) {
            userservice.insertInfo(realame, password, phonenum);
            flag = "1";
        } else {
            flag = "0";
        }
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("flag", flag);
        jsonObject.put("phone", phone);
        return jsonObject;
    }

    public void test(String realame, String password, String phonenum) {
        userservice.insertInfo(realame, password, phonenum);
    }

    @RequestMapping(value = "/login")
    public String login(@RequestParam("phonenum") String phonenum, @RequestParam("password") String password) {
        if (userservice.checkLogin(phonenum, password)) {
            return "redirect:/index.html";
        } else {
            return "redirect:/zhuce.html";
        }
    }
}
