
import com.xust.dao.AverageDao;
import com.xust.service.ReadRunService;
import com.xust.utils.AbstractDao;
import com.xust.utils.AverageUtil;
import com.xust.utils.DataUtils;
import com.xust.utils.RedisPoll;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

/**
 * Created by lenovo on 2018/5/21.
 */
public class TestRedis {

    @Test
    public void testread() {
       /* long start = System.currentTimeMillis();
        String strt = "1";
        System.out.println(strt.split("_")[0]);
        String[] str = new ReadRunService().getData("1", "1", "1", "20180325", "20180325");
        System.out.println("time:" + (System.currentTimeMillis() - start));
        for (int i = 0;i<str.length;i++){
            System.out.println(str[i]);
        }
       //StringBuilder sb = new StringBuilder(str[0]).append(",12342/123456");
        //str = sb.toString().split("kkkk");
        AverageDao[] abstractDaos = new AverageUtil().getAverage(str[0].split(":")[1].split(","), 0.90);
        for (int i = 0; i < abstractDaos.length; i++) {
            System.out.println(abstractDaos[i]);
        }

        System.out.println(((int)(Math.random()*15+15)));
        System.out.println(RedisPoll.getResource().get("1_2_2_20180325"));*/
        /*for (int i = 1; i < 3; i++) {
            for (int j = 1; j < 5; j++) {
                for (int k = 1; k < 3; k++) {*/
                    String key = "1_1_1_20180613";
                    System.out.println(RedisPoll.getResource().get(key));
        /*        }
            }
        }*/
    }

    @Test
    public void test() {
        /*Jedis jedis = RedisPoll.getResource();
        System.out.println(jedis.get("2"));*/
       /* ExecutorService pool = Executors.newCachedThreadPool();
        Future<Double[]> f1 = pool.submit(new SSDBClient("3"));
        Future<Double[]> f2 = pool.submit(new SSDBClient("4"));
        try {
            Double[] value = f1.get();
            for (int i = 0;i<value.length;i++){
                System.out.println(value[i]);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }*/
       /* String zhan[] = {"1", "2", "3", "4", "5"};
        //1.瓦斯浓度、温度传感器、流量传感器、负压传感器、一氧化碳传感器
        String type[] = {"1", "2", "3", "4", "5"};
        Jedis jedis = RedisPoll.getResource();

        Random random = new Random();
        long nowtime = System.currentTimeMillis();
        //for (int a = 1; a < 6; a++) {
        for (int b = 1; b < 6; b++) {
            for (int c = 1; c < 5; c++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int i = 0; i <= 86399; i++) {
                    if (i < 86399) {
                        stringBuilder.append((Math.random()/100) + "_" + nowtime + ",");
                    } else {
                        stringBuilder.append((Math.random()/100) + "_" + nowtime);
                    }
                    nowtime += 30 * 60;
                }
                jedis.set(b + "_" + 3 + "_" + c, stringBuilder.toString());
            }
        }*/
        Jedis jedis = RedisPoll.getResource();
        DataUtils ds = new DataUtils();
        String[] data = ds.getSearchKeys("20180426", "20180625");
        Calendar calendar = Calendar.getInstance();
        calendar.set(2018, 2, 25, 0, 0, 0);
      /*  for (int i = 0;i<data.length;i++){
            System.out.println(data[i]);
        }*/
        long starttime = calendar.getTimeInMillis();
        for (int i = 0; i < data.length; i++) {
            if (data[i] != null) {
                StringBuilder keys = new StringBuilder("1_4_1_");
                String key = new String(keys.append(data[i]));
                StringBuilder values = new StringBuilder();
                for (int j = 1; j <= 2880; j++) {
                    Date date = new Date();
                    //Long time = date.getTime();
                    //System.out.println(time);
                    Date d = new Date(starttime);
                    //Date d = new Date(calendar.getTimeInMillis());
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
                    String valuem = sdf.format(d);
                    double will = 1.0;

                    while(Double.valueOf(String.valueOf(will).substring(0,1))>0.00){
                        will = Math.random()*0.0012+0.0008;
                    }
                    if (j < 2880) {
                        values.append(valuem + "/" + will+ ",");
                    } else {
                        values.append(valuem + "/" + will);
                    }
                    starttime = starttime + 30 * 1000;
                }
               /* System.out.println("key:" + key + "value:" + values);*/
                jedis.set(key, values.toString());
                //System.out.println(values.toString());
                System.out.println(key + ":" + jedis.get(key));
                // System.out.println(jedis.get(key));
            }
        }
   /*     long time = System.currentTimeMillis();
        System.out.println(jedis.get("1_1_1"));
        System.out.println(System.currentTimeMillis() - time);*/
    }

    @Test
    public void settest() {
        Jedis jedis = RedisPoll.getResource();
        System.out.println(jedis.get("1_1_1_20180611"));
    }
}
