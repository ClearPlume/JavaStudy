package top.fallenangel.redis.jedis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.HashMap;
import java.util.Map;

public class JedisTest {
    public static void main(String[] args) {
        // 连接Redis
        Jedis jedis = JedisPoolUtil.get("127.0.0.1", 6379);

        // 字符串操作
        System.out.println("jedis.set(\"name\", \"张三\") = " + jedis.set("name", "张三"));
        System.out.println("jedis.get(\"name\") = " + jedis.get("name"));
        System.out.println("jedis.mset(\"age\", \"16\", \"sex\", \"男\") = " + jedis.mset("age", "16", "sex", "男"));
        System.out.println("jedis.mget(\"name\", \"age\", \"sex\") = " + jedis.mget("name", "age", "sex"));
        // list操作
        System.out.println("jedis.rpush(\"course\", \"java\", \"html\", \"css\", \"js\", \"mysql\") = " + jedis.rpush("course", "java", "html", "css", "js", "mysql"));
        System.out.println("jedis.llen(\"course\") = " + jedis.llen("course"));
        System.out.println("jedis.lrange(\"course\", 0, -1) = " + jedis.lrange("course", 0, -1));
        System.out.println("jedis.lrem(\"course\", 0, \"java\") = " + jedis.lrem("course", 0, "java"));
        System.out.println("jedis.llen(\"course\") = " + jedis.llen("course"));
        System.out.println("jedis.lrange(\"course\", 0, -1) = " + jedis.lrange("course", 0, -1));
        // set操作
        System.out.println("jedis.sadd(\"technology\", \"se\", \"html5\", \"css3\", \"ECMAScript6\", \"servlet\") = " + jedis.sadd("technology", "se", "html5", "css3", "ECMAScript6", "servlet"));
        System.out.println("jedis.scard(\"technology\") = " + jedis.scard("technology"));
        System.out.println("jedis.smembers(\"technology\") = " + jedis.smembers("technology"));
        System.out.println("jedis.srem(\"technology\", \"html5\") = " + jedis.srem("technology", "html5"));
        System.out.println("jedis.scard(\"technology\") = " + jedis.scard("technology"));
        System.out.println("jedis.smembers(\"technology\") = " + jedis.smembers("technology"));
        // hash操作
        System.out.println("jedis.hset(\"student\", \"id\", \"110\") = " + jedis.hset("student", "id", "110"));
        System.out.println("jedis.hset(\"student\", \"name\", \"张三\") = " + jedis.hset("student", "name", "张三"));
        System.out.println("jedis.hset(\"student\", \"sex\",\"男\") = " + jedis.hset("student", "sex", "男"));
        System.out.println("jedis.hget(\"student\", \"id\") = " + jedis.hget("student", "id"));
        System.out.println("jedis.hget(\"student\", \"name\") = " + jedis.hget("student", "name"));
        System.out.println("jedis.hget(\"student\", \"sex\") = " + jedis.hget("student", "sex"));
        Map<String, String> teacher = new HashMap<>();
        teacher.put("id", "210");
        teacher.put("name", "angel");
        teacher.put("sex", "女");
        System.out.println("jedis.hmset(\"teacher\", teacher) = " + jedis.hmset("teacher", teacher));
        System.out.println("jedis.hmget(\"teacher\", \"id\", \"name\", \"sex\") = " + jedis.hmget("teacher", "id", "name", "sex"));
        System.out.println("jedis.hdel(\"teacher\", \"id\") = " + jedis.hdel("teacher", "id"));
        System.out.println("jedis.hgetAll(\"teacher\") = " + jedis.hgetAll("teacher"));
        // zset操作
        Map<String, Double> scores = new HashMap<>();
        scores.put("张三", 95D);
        scores.put("李四", 85D);
        scores.put("王五", 89D);
        System.out.println("jedis.zadd(\"scores\", scores) = " + jedis.zadd("scores", scores));
        System.out.println("jedis.zcard(\"scores\") = " + jedis.zcard("scores"));
        System.out.println("jedis.zrange(\"scores\", 0, -1) = " + jedis.zrange("scores", 0, -1));
        System.out.println("jedis.zadd(\"scores\", 96D, \"赵六\") = " + jedis.zadd("scores", 96D, "赵六"));
        System.out.println("jedis.zcard(\"scores\") = " + jedis.zcard("scores"));
        System.out.println("jedis.zrange(\"scores\", 0, -1) = " + jedis.zrange("scores", 0, -1));
        System.out.println("jedis.zrangeByScoreWithScores(\"scores\", 60, 90) = " + jedis.zrangeByScoreWithScores("scores", 60, 90));
        System.out.println("jedis.zrem(\"scores\", \"张三\") = " + jedis.zrem("scores", "张三"));
        System.out.println("jedis.zcard(\"scores\") = " + jedis.zcard("scores"));
        System.out.println("jedis.zrange(\"scores\", 0, -1) = " + jedis.zrange("scores", 0, -1));
        System.out.println("jedis.flushDB() = " + jedis.flushDB());

        // 事务
        Transaction transaction = jedis.multi();
        System.out.println("transaction.mset(\"name\", \"张三\", \"age\", \"25\", \"sex\", \"男\") = " + transaction.mset("name", "张三", "age", "25", "sex", "男"));
        System.out.println("transaction.mget(\"name\", \"age\", \"sex\") = " + transaction.mget("name", "age", "sex"));
        System.out.println("transaction.exec() = " + transaction.exec());

        // 清空当前数据库
        System.out.println("jedis.flushDB() = " + jedis.flushDB());

        // 关闭Redis连接
        jedis.close();
    }
}