package com.example.dao;

import com.example.App;
import com.example.bean.Car;
import com.example.bean.Owner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class OwnerDaoTest {
    @Autowired
    private OwnerDao ownerDao;

    @Test
    public void testSelect() {
//        int id = 1;
//        Owner owner = ownerDao.findOne(id);
////        List<Car> cars = owner.getCars();
//        for (int i = 0; i < cars.size(); i++) {
//            System.out.println(cars.get(i).getPlate());
//        }
    }
}