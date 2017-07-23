package com.example.config;

import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;

/**
 * Created by Administrator on 2017/7/20.
 */
@Component
public class MyRedisPool {
    private JedisPool pool;

    public MyRedisPool() {
        pool = new JedisPool("127.0.0.1", 6379);
    }

    public JedisPool getPool() {
        return pool;
    }

    public void setPool(JedisPool pool) {
        this.pool = pool;
    }

    public Jedis getJedis() {
        return pool.getResource();
    }
}
