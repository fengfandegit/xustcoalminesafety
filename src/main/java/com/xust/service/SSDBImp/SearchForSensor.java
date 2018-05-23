package com.xust.service.SSDBImp;

import com.xust.service.AllSSDBSearchI;
import com.xust.utils.SSDBClient;

/**
 * Created by lenovo on 2018/5/21.
 */
public class SearchForSensor implements AllSSDBSearchI{
    private SSDBClient ssdbClient;

    public void test(String zhan,String type,String no){
        String key = zhan+"_"+type+"_"+no;

    }
}
