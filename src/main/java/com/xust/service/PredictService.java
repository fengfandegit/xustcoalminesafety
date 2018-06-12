package com.xust.service;

import com.xust.dao.AverageDao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * Created by 10045 on 2018/5/29.
 */
public class PredictService {
    public AverageDao[] predictResult(AverageDao[] a) {
        List<AverageDao> listValue = new ArrayList<>();
        List<String> listKey = new ArrayList<>();
        List<Object> list1 = new ArrayList<>();
        AverageDao[] averageDaos2 = {};
        AverageDao[] averageDaos = {};
        Map<String,AverageDao[]> mapnew = new LinkedHashMap<>();
        String[] strings = {};
        for (int i=0;i<a.length;i++
             ) {
            AverageDao averageDao = (AverageDao) a[i];
            listValue.add(averageDao);
        }
        for (int i = 0; i < listValue.size(); i++) {
            list1.add(listValue.get(i));
        }
        try {
            String[] args1 = new String[]{"python",
                    "\\usr\\local\\src\\main.py",
                    String.valueOf(strings)};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件
            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                list1.add(line);
            }
            for (int i = 0; i < averageDaos.length; i++) {
                averageDaos[i].setValues((Double) list1.get(i));
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        if (listKey.size() == listValue.size()){
            for (int i = 0; i < listKey.size(); i++) {
                mapnew.put(listKey.get(i),averageDaos);
            }
        }
        for (int i = 0; i < listValue.size(); i++) {
            averageDaos2[i] = listValue.get(i);
        }
        return averageDaos2;
    }
}
