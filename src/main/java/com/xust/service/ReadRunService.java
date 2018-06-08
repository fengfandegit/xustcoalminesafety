package com.xust.service;

import com.xust.dao.AverageDao;
import com.xust.service.SSDBImp.SearchForSensor;
import com.xust.utils.AverageUtil;
import com.xust.utils.DataUtils;
import com.xust.utils.ExecutorsUtil;
import org.springframework.stereotype.Service;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListSet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * Created by lenovo on 2018/5/30.
 */
@Service
public class ReadRunService {

    public String[] getData(String no, String type, String id, String starttime, String endtime) {
        String nos[] = no.split("_");
        String types[] = type.split("_");
        String ids[] = id.split("_");
        String[] keys = DataUtils.getSearchKeys(starttime, endtime);
        String pre[] = new String[nos.length * keys.length];
        int m = 0;
        for (int j = 0; j < keys.length; j++) {
            for (int i = 0; i < nos.length; i++) {
                pre[m++] = nos[i] + "_" + types[i] + "_" + ids[i] + "_" + keys[j];
            }
        }
        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        CountDownLatch countDownLatch = new CountDownLatch(pre.length);
        for (int i = 0; i < pre.length; i++) {
            ExecutorsUtil.cachedThreadPool.submit(
                    new SearchForSensor(countDownLatch, pre[i], concurrentHashMap));
        }
        try {
            //countDownLatch.await(1000 * 10, TimeUnit.MILLISECONDS);
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String returndatas[] = new String[pre.length];
        for (int i = 0; i < pre.length; i++) {
            if (pre[i] != null) {
                returndatas[i] = pre[i] + ":" + concurrentHashMap.get(pre[i]);
            }
        }
        int newlen = 0;
        for (int i = 0;i<returndatas.length;i++){
            if (!returndatas[i].split(":")[1].equals("null")){
                newlen++;
            }
        }
        String prestr[] = new String[newlen];
        int temp = 0;
        for (int i = 0;i<returndatas.length;i++){
            if (!returndatas[i].split(":")[1].equals("null")){
                prestr[temp++] = returndatas[i];
            }
        }
        //System.out.println("sss");
        /*
        AverageDao[] a = new AverageUtil().getAverage(returndatas,0.90);*/
        return prestr;
    }
}
