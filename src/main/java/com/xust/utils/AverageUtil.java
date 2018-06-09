package com.xust.utils;

import com.xust.dao.AverageDao;

/**
 * Created by lenovo on 2018/5/30.
 */
public class AverageUtil {
    public AverageDao[] getAverage(String[] data, Double alarm) {
        if (data != null && data.length > 0) {
            AverageDao[] averageDao = new AverageDao[156];
            int baselen = data.length / 150;
            int endt = baselen * 150;
            double temp = 0;
            boolean flag = false;
            int j = 0;
            double dat;
            String starttime = "";
            String endtime = "";
            for (int i = 0; i < data.length; i++) {
                if (i == 0) {
                    starttime = data[i].split("/")[0];
                }
                dat = Double.parseDouble(data[i].split("/")[1]);
                if (dat >= alarm) {
                    flag = true;
                }
                if (i < endt) {
                    temp += dat;
                    if ((i + 1) % baselen == 0 && i > 0) {
                        endtime = data[i].split("/")[0];
                        averageDao[j++] = new AverageDao((double) temp / (double) baselen, data[i - (baselen / 2)]
                                .split("/")[0], flag, starttime, endtime);
                        flag = false;
                        if (i + 1 < data.length) {
                            starttime = data[i].split("/")[0];
                        }
                        temp = 0;
                    }
                } else {
                    temp += dat;
                    if (i == data.length - 1) {
                        averageDao[j++] = new AverageDao((double) temp / (double) (data.length - endt),
                                data[(data.length + endt) / 2]
                                        .split("/")[0], flag, starttime, endtime);
                    }
                }
            }

            return averageDao;
        } else {
            return null;
        }
    }
}
