package com.xust.utils;

import org.apache.log4j.Logger;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;
import java.util.Random;

/**
 * Created by lenovo on 2018/5/16.
 * @Author by fengfan
 */
public class RedisPoll {
    public static List<JedisPool> pools;
    public static int redis_batch_read_num;
    public static int redis_batch_write_num;
    private static Logger logger = Logger.getLogger(RedisPoll.class);

    /**
     * 构建redis连接池
     */
    public static void initPools() {

        try {
            pools = new ArrayList<>();
            String path = System.getProperty("user.dir");
            String logConf = path + "/conf/redis.properties";
            Properties redis_config = new Properties();
            redis_config.load(new FileInputStream(logConf));
            redis_batch_read_num = Integer.parseInt(redis_config.getProperty("redis.batch_read_num"));
            redis_batch_write_num = Integer.parseInt(redis_config.getProperty("redis_batch_write_num"));
            String ip_ports = redis_config.getProperty("redis.addr");
            String[] addrs = ip_ports.split(";");
            for (String addr : addrs) {
                JedisPoolConfig config = new JedisPoolConfig();
                // 控制一个pool可分配多少个jedis实例，通过pool.getResource()来获取；
                // 如果赋值为-1，则表示不限制；如果pool已经分配了maxActive个jedis实例，则此时pool的状态为exhausted(耗尽)
                config.setMaxTotal(Integer.parseInt(redis_config.getProperty("redis.max_total")));
                // 控制一个pool最多有多少个状态为idle(空闲的)的jedis实例。
                config.setMaxIdle(Integer.parseInt(redis_config.getProperty("redis.max_idle")));
                // 表示当borrow(引入)一个jedis实例时，最大的等待时间，如果超过等待时间，则直接抛出JedisConnectionException；
                config.setMaxWaitMillis(Integer.parseInt(redis_config.getProperty("redis.max_wait")));
                config.setMinIdle(10);// 设置最小空闲数
                // 在borrow一个jedis实例时，是否提前进行validate操作；如果为true，则得到的jedis实例均是可用的；
                config.setTestOnBorrow(true);
                config.setTestWhileIdle(true);
                // 表示idle object evitor两次扫描之间要sleep的毫秒数
                config.setTimeBetweenEvictionRunsMillis(30000);
                // 表示idle object evitor每次扫描的最多的对象数
                config.setNumTestsPerEvictionRun(10);
                // 表示一个对象至少停留在idle状态的最短时间，然后才能被idle object
                // evitor扫描并驱逐；这一项只有在timeBetweenEvictionRunsMillis大于0时才有意义
                config.setMinEvictableIdleTimeMillis(60000);
                String[] ip_port = addr.split(":");
                JedisPool pool = new JedisPool(config, ip_port[0],
                        Integer.parseInt(ip_port[1]),
                        Integer.parseInt(redis_config.getProperty("redis.time_out")));
                if(pool != null) {
                    pools.add(pool);
                    logger.info("init redis pool:" + ip_port + " success");
                }
            }
        } catch (Exception e) {
            logger.error("fail to init redis client", e);
        }
    }

    public static Jedis getResource() {
        int num = new Random().nextInt(pools.size());
        JedisPool pool = pools.get(num);
        Jedis jedis = pool.getResource();
        return jedis;
    }
}
