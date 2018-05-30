package com.xust.utils;

import com.xust.dao.AverageDao;

/**
 * Created by lenovo on 2018/5/30.
 */
public class AverageUtil {
    public AverageDao[] getAverage(String[] data, Double alarm) {
        AverageDao[] averageDao = new AverageDao[121];
        int baselen = data.length / 120;
        int endt = baselen * 120;
        double temp = 0;
        boolean flag = false;
        int j = 0;
        double dat;
        for (int i = 0; i < data.length; i++) {
            dat = Double.parseDouble(data[i].split("/")[1]);
            if (dat >= alarm) {
                flag = true;
            }
            if (i < endt) {
                temp += dat;
                if ((i+1) % baselen == 0 && i > 0) {
                    averageDao[j++] = new AverageDao((double) temp / (double) baselen, data[i - (baselen / 2)]
                            .split("/")[0], flag);
                    flag = false;
                    temp = 0;
                }
            } else {
                temp += dat;
                if (i == data.length - 1) {
                    averageDao[j++] = new AverageDao((double) temp / (double) (data.length - endt),
                            data[(data.length + endt) / 2]
                                    .split("/")[0], flag);
                }
            }
        }
        System.out.println();
        return averageDao;
    }
}
