package com.xust.service.SSDBImp;

import com.xust.service.AllSSDBSearchI;
import com.xust.utils.DataUtils;
import com.xust.utils.RedisPoll;
import com.xust.utils.SSDBClient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import redis.clients.jedis.Jedis;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lenovo on 2018/5/21.
 */
@AllArgsConstructor
@Getter
@Setter
public class SearchForSensor implements AllSSDBSearchI {
    //private SSDBClient ssdbClient;
    CountDownLatch countDownLatch;
    String key;
    ConcurrentHashMap<String, String> concurrentHashMap;


    @Override
    public void run() {
        Jedis jedis = RedisPoll.getResource();
        String values = jedis.get(key);
        if (values != null) {
            concurrentHashMap.put(key, values);
        }
        jedis.close();
        countDownLatch.countDown();

    }
}
