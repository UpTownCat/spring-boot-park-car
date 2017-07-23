package com.example.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.example.bean.Parking;
import com.example.config.MyRedisPool;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import redis.clients.jedis.Jedis;

/**
 * Created by Administrator on 2017/7/20.
 */
@Component
public class ParkingRedisDao {
    @Autowired
    private MyRedisPool redisPool;
    private RuntimeSchema<Parking> schema = RuntimeSchema.createFrom(Parking.class);

    public void saveParking(Parking parking) {
        Jedis jedis = redisPool.getJedis();
        String key = "parking:" + parking.getId();
        byte[] bytes = ProtostuffIOUtil.toByteArray(parking, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        int expireTime = 60* 60;
        String result = jedis.setex(key.getBytes(), expireTime, bytes);
    }

    public Parking getParking(int id) {
        Parking parking = new Parking();
        Jedis jedis = redisPool.getJedis();
        String key = "parking:" + id;
        byte[] bytes = jedis.get(key.getBytes());
        ProtostuffIOUtil.mergeFrom(bytes, parking, schema);
        return parking;
    }

}
