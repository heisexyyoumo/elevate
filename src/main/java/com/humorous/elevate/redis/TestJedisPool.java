package com.humorous.elevate.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

public class TestJedisPool {

    public static void main(String[] args) {
        JedisPool jedisPool = JedisPoolUtil.getJedisPoolInstance();
        Jedis jedis = null;
        try {
            jedis = jedisPool.getResource();
            jedis.set("aa", "bb");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JedisPoolUtil.release(jedis);
        }
    }
}
