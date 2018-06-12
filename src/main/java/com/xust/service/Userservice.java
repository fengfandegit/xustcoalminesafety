package com.xust.service;

import com.xust.dao.User;
import com.xust.dao.UserMapper;
import com.xust.utils.MD5.MD5Util;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Random;
import java.util.UUID;

/**
 * Created by lenovo on 2018/5/16.
 */
@Service
@MapperScan("com.xust.dao")
@ComponentScan(basePackages = {"com.xust.dao"})
public class Userservice {
    @Autowired
    UserMapper userMapper;

    public boolean checkLogin(String phonenum, String password) {
        boolean falg = false;
        try {
            User user = userMapper.findUserByName(phonenum);
            if (user != null) {
                if (this.checkLoginPass(password, user)) {
                    falg = true;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return falg;
        }
    }

    public boolean checkInsert(String phonenum){
        boolean flag = false;
        try {
            User user = userMapper.findUserByName(phonenum);
            if (user != null) {
                flag = true;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return flag;
    }

    public boolean checkLoginPass(String password, User user) {
        boolean flag = false;
        try {
            String realpass = MD5Util.EncoderByMd5(password + "/" + user.getSalt());
            if (realpass.equals(user.getPassword())) {
                flag = true;
            }
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } finally {
            return flag;
        }
    }

    public String getSalt() {
        Random random = new Random();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public void insertInfo(String realname, String password, String phonenum) {
        String salt = this.getSalt();
        try {
            userMapper.insertInfo(UUID.randomUUID().toString(), phonenum,
                    MD5Util.EncoderByMd5(password + "/" + salt), realname, "test", 0, "test", salt);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
