package com.xust.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by 10045 on 2018/5/29.
 */
public class PredictService {
    public static void main (String [] args) {
// TODO Auto-generated method stub
        int b = 23;
        try {
            //从kafka中取出来数据
            //将b放入python代码中
            String[] args1 = new String[]{"python",
                    "C:\\Users\\10045\\Desktop\\model\\new model\\test2\\main.py",
                    String.valueOf(b)};
            Process proc = Runtime.getRuntime().exec(args1);// 执行py文件

            BufferedReader in = new BufferedReader(new InputStreamReader(proc.getInputStream()));
            String line = null;
            while ((line = in.readLine()) != null) {
                System.out.println(line);
            }
            in.close();
            proc.waitFor();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
