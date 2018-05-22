import com.xust.dao.SSDBClient;
import com.xust.utils.RedisPoll;
import org.junit.Test;
import redis.clients.jedis.Jedis;

import java.util.concurrent.*;

/**
 * Created by lenovo on 2018/5/21.
 */
public class TestRedis {
    @Test
    public void test(){
        /*Jedis jedis = RedisPoll.getResource();
        System.out.println(jedis.get("2"));*/
        ExecutorService pool = Executors.newCachedThreadPool();
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
        }

    }

    @Test
    public void settest(){
        Jedis jedis = RedisPoll.getResource();
        jedis.set("3","1;2;3;4;5;6;7;8;9;0");
        jedis.set("4","0;9;8;7;6;5;4;3;2;1");
        System.out.println(jedis.get("3"));
    }
}
