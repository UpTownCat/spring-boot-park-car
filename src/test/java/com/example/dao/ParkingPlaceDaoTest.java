package com.example.dao;

import com.example.App;
import com.example.bean.ParkingPlace;
import com.example.bean.ParkingSeat;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/7/16.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ParkingPlaceDaoTest {
    @Autowired
    private ParkingPlaceDao parkingPlaceDao;

    @Test
    public void insertBatchTest() {
        List<ParkingPlace> places = new ArrayList<>();
        for(int i = 0; i < 100; i++) {
            ParkingPlace place = new ParkingPlace();
            place.setName("测试停车场" + (i + 1));
            place.setMoneyPerHour(3.5);
            place.setLocation("测试地点" + (i + 1));
            places.add(place);
        }
        parkingPlaceDao.save(places);
    }

    @Test
    public void testSelect() {
//        int id = 1;
//        ParkingPlace parkingPlace = parkingPlaceDao.findOne(id);
//        List<ParkingSeat> seats = parkingPlace.getParkingSeats();
//        for(int i = 0; i <seats.size(); i++) {
//            System.out.println(seats.get(i).getSequenceNum());
//        }
    }
}