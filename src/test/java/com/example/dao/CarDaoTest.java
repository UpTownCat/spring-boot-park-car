package com.example.dao;

import com.example.App;
import com.example.bean.Car;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Administrator on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class CarDaoTest {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private CarDao carDao;

    @Test
    public void testSelect() {
        Car car = carDao.findOne(22);
        System.out.println(car.getOwner());
    }
}