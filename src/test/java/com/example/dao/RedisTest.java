package com.example.dao;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.dyuproject.protostuff.runtime.RuntimeSchema;
import com.example.App;
import com.example.bean.Owner;
import com.example.bean.Parking;
import com.example.bean.ParkingSeat;
import com.example.config.MyRedisPool;
import com.google.gson.Gson;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import redis.clients.jedis.Jedis;

import java.util.Date;
import java.util.concurrent.TimeUnit;

/**
 * Created by Administrator on 2017/7/20.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest(classes = App.class)
public class RedisTest {
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private ParkingSeatDao parkingSeatDao;

    @Autowired
    MyRedisPool pool;

    @Autowired
    ParkingRedisDao redisDao;

    @Autowired
    private ParkingDao parkingDao;

    RuntimeSchema<Parking> schema = RuntimeSchema.createFrom(Parking.class);

    @Test
    public void test() throws Exception {
        Jedis jedis = pool.getJedis();
//        jedis.sete
        String key = "parking:1";
        byte[] bytes = jedis.get(key.getBytes());
        Parking parking = new Parking();
        try {
            ProtostuffIOUtil.mergeFrom(bytes, parking, schema);
            System.out.println(parking.getPrice() + "------------------");
        } catch (Exception e) {

        }
    }

    @Test
    public void save() throws Exception {
        Jedis jedis = pool.getJedis();
        String key = "parking:1";
        Parking parking = new Parking();
        parking.setPrice(111.4);
        parking.setId(1);
        parking.setOutTime(new Date());
        byte[] bytes = ProtostuffIOUtil.toByteArray(parking, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
        int timeout = 60;
        String result = jedis.setex(key.getBytes(), timeout, bytes);
        System.out.println(result + "-------------" + redisDao);
    }

    @Test
    public void testObj() throws Exception {
        Owner user = new Owner();
        user.setName("Uptowncat");
        user.setId(3);
        user.setEmail("1234234234@qq.com");
        ValueOperations<String, Owner> operations = redisTemplate.opsForValue();
        operations.set("com.neox", user);
        operations.set("com.neo.f", user, 1, TimeUnit.SECONDS);
        Thread.sleep(1000);
        //redisTemplate.delete("com.neo.f");
        boolean exists = redisTemplate.hasKey("com.neo.f");
        if (exists) {
            System.out.println("exists is true");
        } else {
            System.out.println("exists is false");
        }
        // Assert.assertEquals("aa", operations.get("com.neo.f").getUserName());
    }

    @Test
    public void testSaveSeat() {
        int id = 9;
        ParkingSeat parkingSeat = parkingSeatDao.findOne(id);
        Parking parking = new Parking();
        parking.setInTime(new Date());
        parking.setCar(parkingSeat.getCar());
        parking.setParkingPlace(parkingSeat.getParkingPlace());
        parking.setPrice(10.0);
        parkingDao.save(parking);
        Gson gson = new Gson();
        String json = gson.toJson(parking);
        redisTemplate.opsForValue().set("parking:" + parking.getId(), json, 1, TimeUnit.MINUTES);
        Parking parking1 = gson.fromJson(json, Parking.class);
        System.out.println(parking1.getCar().getOwner().getName());
    }
}

