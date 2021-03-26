package com.humorous.elevate.redis;

import redis.clients.jedis.Jedis;
import redis.clients.jedis.Transaction;

import java.util.concurrent.TimeUnit;

/**
 * 测试redis事务
 */
public class TestTx {
    public static void main(String[] args) throws InterruptedException {
//        Jedis jedis = new Jedis("192.168.0.111", 6379);
//
//        Transaction transaction = jedis.multi();
//        transaction.set("k4", "v44");
//        transaction.set("k5", "v55");
////        transaction.exec();
//        transaction.discard();
        new TestTx().transMethod();

    }

    public boolean transMethod() throws InterruptedException {
        Jedis jedis = new Jedis("192.168.0.111", 6379);
        int balance;  // 可用余额
        int debt;  // 欠款
        int amtToSubtract = 10;  //实刷额度
        jedis.watch("balance");
        TimeUnit.SECONDS.sleep(7);
        balance = Integer.parseInt(jedis.get("balance"));
        if (balance < amtToSubtract) {
            jedis.unwatch();
            System.out.println("modify");
            return false;
        } else {
            System.out.println("****transaction****");
            Transaction transaction = jedis.multi();
            transaction.decrBy("balance", amtToSubtract);
            transaction.incrBy("debt", amtToSubtract);
            transaction.exec();
            balance = Integer.parseInt(jedis.get("balance"));
            debt = Integer.parseInt(jedis.get("debt"));
            System.out.println("****" + balance + "****");
            System.out.println("****" + debt + "****");
            return true;

        }
    }
}
