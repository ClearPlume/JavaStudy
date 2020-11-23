package top.fallenangel.springboot.p2p.util;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Component;
import top.fallenangel.springboot.p2p.model.vo.NameValuePair;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;
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
        return getValueFromRedis(key, operator, 5, TimeUnit.MINUTES);
    }

    /**
     * 从Redis中获取key的value，若key不存在，则执行operator，从数据库查找key的值并存入Redis
     *
     * @param key      要查找/设置的key
     * @param operator key不存在时，要进行的操作
     * @param timeout  超时时间
     * @param timeUnit 超时的时间单位
     * @return 最终的value值
     */
    public String getValueFromRedis(String key, Operator operator, long timeout, TimeUnit timeUnit) {
        String valueStr = redis.opsForValue().get(key);
        if (valueStr == null) {
            synchronized (this) {
                valueStr = redis.opsForValue().get(key);
                if (valueStr == null) {
                    valueStr = operator.operation();
                    redis.opsForValue().set(key, valueStr, timeout, timeUnit);
                }
            }
        }
        return valueStr;
    }

    /**
     * 将验证码存入Redis
     *
     * @param phone    手机号
     * @param authCode 验证码
     * @param timeout  超时时间
     * @param timeUnit 超时的时间单位
     */
    public void setAuthCode(String phone, String authCode, long timeout, TimeUnit timeUnit) {
        redis.opsForValue().set(phone, authCode, timeout, timeUnit);
    }

    /**
     * 从Redis中获取验证码
     *
     * @param key 手机号
     * @return value 验证码
     */
    public String getAuthCode(String key) {
        return redis.opsForValue().get(key);
    }

    /**
     * 向Redis中插入zSet。若value已存在，则累加score
     *
     * @param key   键
     * @param value 值
     * @param score 分数
     */
    public void zIncrementScore(String key, String value, double score) {
        redis.opsForZSet().incrementScore(key, value, score);
    }

    /**
     * 以list的形式，从Redis中获取zset，score从高到低
     *
     * @param key   键
     * @param start 起始index
     * @param end   结束index
     * @return 结果list
     */
    public List<NameValuePair> zReverseRangeWithScores(String key, long start, long end) {
        List<NameValuePair> valuePairs = new ArrayList<>();

        Set<ZSetOperations.TypedTuple<String>> tuples = redis.opsForZSet().reverseRangeWithScores(key, start, end);
        assert tuples != null;
        tuples.forEach(tuple -> valuePairs.add(new NameValuePair(tuple.getValue(), tuple.getScore())));
        return valuePairs;
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
