package com.xust.service;

import com.xust.dao.AboutZhan;
import com.xust.dao.AverageDao;
import com.xust.service.SSDBImp.SearchForSensor;
import com.xust.utils.AverageUtil;
import com.xust.utils.DataUtils;
import com.xust.utils.ExecutorsUtil;
import com.xust.utils.RedisPoll;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import redis.clients.jedis.Jedis;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

/**
 * Created by lenovo on 2018/5/30.
 */
@Service
public class ReadRunService {

    /**
     * @param no        传感器所在站点1_1表示要查询的两个传感器都是1站点
     * @param type      传感器类型，解释同上
     * @param id        传感器具体的id
     * @param starttime 起始时间，年月日
     * @param endtime   结束时间，年月日
     * @return 返回的是前端曲线展示的协定数据格式
     */
    public Map<String, AverageDao[]> getData(String no, String type, String id, String starttime,
                                             String endtime,String black,boolean flag) {
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
            if (RedisPoll.getResource().exists(pre[i])) {
                ExecutorsUtil.cachedThreadPool.submit(
                        new SearchForSensor(countDownLatch, pre[i], concurrentHashMap));
            }
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
        for (int i = 0; i < returndatas.length; i++) {
            if (returndatas[i]!=null&&!returndatas[i].split(":")[1].equals("null")) {
                newlen++;
            }
        }
        String prestr[] = new String[newlen];
        int temp = 0;
        for (int i = 0; i < returndatas.length; i++) {
            if (!returndatas[i].split(":")[1].equals("null")) {
                prestr[temp++] = returndatas[i];
            }
        }
        return this.test(prestr,black,flag);
    }

    public Map<String, AverageDao[]> test(String[] realdatas,String black,boolean flag) {
        HashMap<String, StringBuilder> map = new HashMap<>();
        Map<String, AverageDao[]> returnmap = new HashMap<>();
        for (int i = 0; i < realdatas.length; i++) {
            String[] keys = realdatas[i].split(":")[0].split("_");
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < keys.length - 1; j++) {
                if (j < keys.length - 2) {
                    key.append(keys[j] + "_");
                } else {
                    key.append(keys[j]);
                }
            }
            map.put(key.toString(), new StringBuilder());
        }
        for (int i = 0; i < realdatas.length; i++) {
            String[] keys = realdatas[i].split(":")[0].split("_");
            StringBuilder key = new StringBuilder();
            for (int j = 0; j < keys.length - 1; j++) {
                if (j < keys.length - 2) {
                    key.append(keys[j] + "_");
                } else {
                    key.append(keys[j]);
                }
            }
            if (map.get(key.toString()).toString().length() == 0) {
                map.get(key.toString()).append(realdatas[i].split(":")[1]);
            } else {
                map.get(key.toString()).append("," + realdatas[i].split(":")[1]);
            }
        }
        Iterator<String> it = map.keySet().iterator();
        AverageDao[] abstractDaos;
        while (it.hasNext()) {
            String key = it.next();
            abstractDaos = new AverageUtil().getAverage(map.get(key).toString().split(","), 0.90,black,flag);

            int newlen = 0;
            for (int i = 0; i < abstractDaos.length; i++) {
                if (abstractDaos[i] != null) {
                    newlen++;
                }
            }
            AverageDao[] realDaos = new AverageDao[newlen];
            int temp = 0;
            for (int i = 0; i < abstractDaos.length; i++) {
                if (abstractDaos[i] != null) {
                    realDaos[temp++] = abstractDaos[i];
                }
            }
            returnmap.put("S" + key, realDaos);
        }
        return returnmap;
    }


    public Map<String, AverageDao[]> getNowDatas(String no, String type, String id, String data) {
        //兼容下层调用模块
        return this.getData(no, type, id, data, data,"d0",false);
    }

    public Map<String, AboutZhan[]> getAboutZhan() {

        int num = ((int) Math.random() * 80) + 20;
        AboutZhan[] aboutZhen = new AboutZhan[num];
        for (int i = 0; i < aboutZhen.length; i++) {
            String id = i + "";
            String panqu = ((int) (Math.random() * 10) + 1) + "盘区";
            String choucainame = ((int) (Math.random() * 2000) + 2000) + "采空区";
            String installaction = ((int) (Math.random() * 2000) + 2000) + "";
            String mixnum = ((Double) (Math.random() * 30) + 4) + "";
            String jueya = ((int) (Math.random() * 20) + 80) + "";
            String fuya = ((int) (Math.random() * -20) + 18) + "";
            String wendu = ((int) (Math.random() * 20) + 20) + "";
            String chunliuliang = ((int) (Math.random() * 10) + 0.25) + "";
            String sunliulangleiji = ((int) (Math.random() * 2000) + 200) + "";
            String riliuliangleiji = ((int) (Math.random() * 500) + 30) + "";
            String chunliuliangshilieji = ((int) (Math.random() * 30000) + 3000) + "";
            String chunliuliangrileiji = ((int) (Math.random() * 4000) + 500) + "";
            String chunliuliangyueleiji = ((int) (Math.random() * 30000) + 8000) + "";
            aboutZhen[i] = new AboutZhan(id, panqu, choucainame, installaction, mixnum, jueya, fuya, wendu, chunliuliang, sunliulangleiji
                    , riliuliangleiji, chunliuliangshilieji, chunliuliangrileiji, chunliuliangyueleiji);
        }
        Map<String, AboutZhan[]> map = new HashMap<>();
        map.put("values",aboutZhen);
        return map;
    }

}
