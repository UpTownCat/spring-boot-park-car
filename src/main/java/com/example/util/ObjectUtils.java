package com.example.util;

import com.dyuproject.protostuff.LinkedBuffer;
import com.dyuproject.protostuff.ProtostuffIOUtil;
import com.example.bean.Parking;
import org.springframework.data.redis.core.StringRedisTemplate;

/**
 * Created by Administrator on 2017/7/20.
 */
public class ObjectUtils {
//    private ObjectUtils() {
//
//    }
//
//    public void serialzeObject(int id, Parking parking, StringRedisTemplate template) {
//        RuntimeSchema schema = RuntimeSchema.createFrom(parking.getClass());
//        String key = "parking" + id;
//        byte[] bytes = ProtostuffIOUtil.toByteArray(parking, schema, LinkedBuffer.allocate(LinkedBuffer.DEFAULT_BUFFER_SIZE));
//
//    }
}
