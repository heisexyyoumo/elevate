package com.humorous.elevate.redis;

import redis.clients.jedis.Jedis;

/**
 * 测试是否连接redis
 */
public class TestPing {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.111", 6379);
        System.out.println(jedis.ping());
    }
}
