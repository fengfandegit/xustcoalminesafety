package com.xust.utils;

/**
 * Created by lenovo on 2018/5/28.
 */
public class DataUtils {
    private static final int[] data = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    private static boolean getYear(int year) {
        boolean flag = false;
        if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0)
            flag = true;
        return flag;
    }

    //start:20180425     end 20180525
    public static String[] getSearchKeys(String start, String end) {
        boolean bool = getYear(Integer.parseInt(start.substring(0, 4)));
        StringBuilder real_data = new StringBuilder();
        int j = 0;
        for (int i = Integer.parseInt(start); i <= Integer.parseInt(end); i++) {
            StringBuilder stringBuilder = new StringBuilder();
            int temp = i % 1000;
            temp = temp / 100;
            int mothdata = -1;
            if (temp < 13) {
                mothdata = data[temp % data.length];
            }
            if (bool && temp == 2) {
                mothdata = 29;
            }
            stringBuilder.append(i/100);
            int te = i % 100;
            if (te <= mothdata) {
                if (te >= 10) {
                    stringBuilder.append(te);
                } else {
                    stringBuilder.append("0" + te);
                }
                if (te > 0 && i < Integer.parseInt(end)) {
                    real_data.append(stringBuilder.toString() + "&");
                } else {
                    real_data.append(stringBuilder.toString());
                }
            }
        }
        return real_data.toString().split("&");
    }
}
