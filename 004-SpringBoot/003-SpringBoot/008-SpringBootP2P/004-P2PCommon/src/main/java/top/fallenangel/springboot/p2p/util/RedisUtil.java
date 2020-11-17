package top.fallenangel.springboot.p2p.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;

@Component
public class RedisUtil {
    private final RedisTemplate<String, String> redis;

    public RedisUtil(RedisTemplate<String, String> redis) {
        this.redis = redis;
    }

    /**
     * 从Redis中获取key的value，若key不存在，则执行operator，从数据库查找key的值并存入Redis，默认超时时间为6小时
     *
     * @param key      要查找/设置的key
     * @param operator key不存在时，要进行的操作
     * @return 最终的value值
     */
    public String getValueFromRedis(String key, Operator operator) {
        return getValueFromRedis(key, operator, 6, TimeUnit.HOURS);
    }

    /**
     * 从Redis中获取key的value，若key不存在，则执行operator，从数据库查找key的值并存入Redis
     *
     * @param key      要查找/设置的key
     * @param operator key不存在时，要进行的操作
     * @param timeout  超时时间
     * @param unit     超时的时间单位
     * @return 最终的value值
     */
    public String getValueFromRedis(String key, Operator operator, long timeout, TimeUnit unit) {
        String valueStr = redis.opsForValue().get(key);
        if (valueStr == null) {
            synchronized (this) {
                valueStr = redis.opsForValue().get(key);
                if (valueStr == null) {
                    valueStr = operator.operation();
                    redis.opsForValue().set(key, valueStr, timeout, unit);
                }
            }
        }
        return valueStr;
    }

    /**
     * 从Redis中获取key的value的过程中，若key不存在时，要进行的操作
     */
    public interface Operator {
        /**
         * 执行将数据从数据库中取出的操作
         *
         * @return 数据库中取出，转成String的数据
         */
        String operation();
    }
}
