package com.xust.utils;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by lenovo on 2018/6/10.
 */
public class SendNowData implements Runnable {
    private static final Logger logger = Logger.getLogger(SendNowData.class);
    @Override
    public void run() {
        Jedis jedis = RedisPoll.getResource();
        try {
            while (true) {
                logger.info("test");
                Date d = new Date(System.currentTimeMillis());
                SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd");
                String valuem = sdf.format(d);
                for (int i = 1; i < 3; i++) {
                    for (int j = 1; j < 5; j++) {
                        for (int k = 1; k < 3; k++) {
                            String key = i + "_" + j + "_" + k + "_" + valuem;
                            Double value = 1.0;
                            switch (j) {
                                case 1:
                                    value = Math.random();
                                    break;
                                case 2:
                                    value = (Math.random() * 15) + 15;
                                    break;
                                case 3:
                                    value = (Math.random() * 699.5) + 0.5;
                                    break;
                                case 4:
                                    while (Double.valueOf(String.valueOf(value).substring(0, 1)) > 0.00) {
                                        value = Math.random() * 0.0012 + 0.0008;
                                    }
                                    break;
                            }
                            Date dn = new Date(System.currentTimeMillis());
                            SimpleDateFormat sdfn = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                            StringBuilder stringBuilder;
                            if (jedis.exists(key) && jedis.get(key).length() > 1) {
                                stringBuilder = new StringBuilder(jedis.get(key));
                                stringBuilder.append("," + sdfn.format(dn) + "/" + value);
                            } else {
                                stringBuilder = new StringBuilder(sdfn.format(dn) + "/" + value);
                            }
                            jedis.set(key, stringBuilder.toString());
                            jedis.close();
                        }
                    }
                }
                Thread.sleep(30000);
            }
        } catch (Exception e) {

        }

    }
}
