
import com.xust.utils.RedisPoll;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.Random;

/**
 * Created by lenovo on 2018/5/21.
 */
public class TestRedis {
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
        String zhan[] = {"1", "2", "3", "4", "5"};
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
        }

   /*     long time = System.currentTimeMillis();
        System.out.println(jedis.get("1_1_1"));
        System.out.println(System.currentTimeMillis() - time);*/
    }

    @Test
    public void settest() {
        Jedis jedis = RedisPoll.getResource();
        jedis.set("3", "1;2;3;4;5;6;7;8;9;0");
        jedis.set("4", "0;9;8;7;6;5;4;3;2;1");
        System.out.println(jedis.get("3"));
    }
}
