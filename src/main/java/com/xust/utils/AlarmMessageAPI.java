package com.xust.utils;

import com.xust.utils.message.api.MessageAPI;
import org.apache.log4j.Logger;

import java.util.ArrayList;

/**
 * Created by lenovo on 2018/5/22.
 */
public class AlarmMessageAPI extends MessageAPI {
    private static final Logger logger = Logger.getLogger(AlarmMessageAPI.class);

    @Override
    public void sendVerificationCode(int appid, String appkey, String phoneNum, int templateId, String smsSign) {
        ArrayList<String> message = new ArrayList<>();
        message.add("url");
        try {
            super.send_Message(appid, appkey, phoneNum, templateId, smsSign, message);
        } catch (Exception e) {
            //e.printStackTrace();
            logger.error("", e);
        }
    }

    @Override
    public void run() {
        //nothing
    }
}
