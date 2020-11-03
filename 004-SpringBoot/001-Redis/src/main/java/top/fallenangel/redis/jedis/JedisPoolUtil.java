package top.fallenangel.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

public class JedisPoolUtil {
    public static Jedis get(String host, int port) {
        JedisPoolConfig config = new JedisPoolConfig();
        config.setMaxIdle(16);
        config.setMaxTotal(64);
        config.setMinIdle(3);
        config.setTestOnBorrow(true);

        JedisPool pool = new JedisPool(config, host, port);
        return pool.getResource();
    }
}