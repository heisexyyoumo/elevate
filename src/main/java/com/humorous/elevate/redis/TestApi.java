package com.humorous.elevate.redis;

import redis.clients.jedis.Jedis;

import java.util.Set;

/**
 * 测试redis的api
 */
public class TestApi {
    public static void main(String[] args) {
        Jedis jedis = new Jedis("192.168.0.111", 6379);
        jedis.set("K1", "v1");
        jedis.set("K2", "v2");
        jedis.set("K3", "v3");

        System.out.println(jedis.get("K1"));

        Set<String> keys = jedis.keys("*");
        keys.forEach(System.out::print);

    }
}
