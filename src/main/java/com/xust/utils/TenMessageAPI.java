package com.xust.utils;

import com.xust.utils.message.api.MessageAPI;
import org.apache.log4j.Logger;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by lenovo on 2018/5/14.
 *
 * @Author fengfan
 */
public class TenMessageAPI extends MessageAPI {
    private static final Logger logger = Logger.getLogger(TenMessageAPI.class);
    //key :phonenum,value:Verification Code_System.currentTimeMillis(超过定时销毁,定时任务来做)
    private static final ConcurrentHashMap<String, String> PHONE_NUMS = new ConcurrentHashMap<>();

    private static Random random = new Random();

    static {
        Timer timer = new Timer();
        timer.schedule(new TenMessageAPI(), 60 * 1000);
    }

    private static String get_Random_Verification_Code() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < 4; i++) {
            stringBuilder.append(random.nextInt(10));
        }
        return stringBuilder.toString();
    }

    public void sendVerificationCode(int appid, String appkey, String phoneNum, int templateId, String smsSign) {
        String Code = get_Random_Verification_Code();
        PHONE_NUMS.put(phoneNum, Code + "_" + System.currentTimeMillis());
        try {
            super.send_Message(appid, appkey, phoneNum, templateId, smsSign, Code);
            logger.debug("Phone:" + phoneNum + "_Code:" + Code);
        } catch (Exception e) {
            e.printStackTrace();
            //线上运行使用
            // logger.error("", e);
        }
    }

    @Override
    public void run() {
        try {
            if (PHONE_NUMS.size() > 0) {
                Set<String> sets = PHONE_NUMS.keySet();
                long now_time = System.currentTimeMillis();
                Iterator<String> it = sets.iterator();
                while (it.hasNext()) {
                    String[] values = PHONE_NUMS.get(it).split("_");
                    if (now_time - Long.parseLong(values[1]) > 60 * 1000) {
                        PHONE_NUMS.remove(it);
                    }
                }
            }
        } catch (Exception e) {
            logger.error("", e);
        }
    }
}