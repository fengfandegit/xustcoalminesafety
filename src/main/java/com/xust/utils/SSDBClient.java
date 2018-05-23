package com.xust.utils;

import lombok.AllArgsConstructor;
import redis.clients.jedis.Jedis;

import java.util.concurrent.Callable;

/**
 * Created by lenovo on 2018/5/21.
 */
@AllArgsConstructor
public class SSDBClient implements Callable<Double[]> {
    private String key;

    @Override
    public Double[] call() throws Exception {
        Jedis jedis = RedisPoll.getResource();
        String[] strs = jedis.get(key).split(",");
        Double[] value = new Double[strs.length];
        for (int i = 0; i < strs.length; i++) {
            value[i] = Double.parseDouble(strs[i]);
        }
        return value;
    }
}
