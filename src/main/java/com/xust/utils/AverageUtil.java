package com.xust.utils;

import com.xust.dao.AverageDao;

/**
 * Created by lenovo on 2018/5/30.
 */
public class AverageUtil {
    /**
     *
     * @param data
     * @param alarm
     * @param black 间隔期
     * @param flags 是否走间隔
     * @return
     */
    public AverageDao[] getAverage(String[] data, Double alarm,String black,boolean flags) {
        /*int i = Integer.parseInt(black.substring(1,black.length()));*/
        int allnum = 0;
        if (flags == false){
            allnum = 150;
        }else {
            if (black.substring(0, 1).equals("d")) {
                allnum = data.length / (2880*Integer.parseInt(black.substring(1,black.length())));
            }else {
                allnum = data.length/(120*Integer.parseInt(black.substring(1,black.length())));
            }
        }
        if (data.length<120){
            allnum = 150;
        }
        AverageDao[] averageDao = new AverageDao[allnum+1];
        if (data != null && data.length > allnum) {
            int baselen = data.length / allnum;
            int endt = baselen * allnum;
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

        } else if (data != null && data.length <= 150) {
            for (int i = 0; i < data.length; i++) {
                String[] values = data[i].split("/");
                boolean flag = false;
                if (Double.valueOf(values[1]) > alarm) {
                    flag = true;
                }
                averageDao[i++] = new AverageDao(Double.valueOf(values[1]), values[0], flag, values[0], values[0]);
            }
        }
        return averageDao;
    }
}
