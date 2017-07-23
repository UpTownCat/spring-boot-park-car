package com.example.dao;

import com.example.App;
import com.example.bean.ParkingPlace;
import com.example.bean.ParkingSeat;
import com.example.service.ParkingPlaceService;
import com.example.service.ParkingSeatService;
import com.example.util.CommonUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by Administrator on 2017/7/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ParkingSeatDaoTest {
    @Autowired
    private ParkingSeatDao parkingSeatDao;

    @Autowired
    private ParkingSeatService parkingSeatService;
    @Test
    public void findByPlaceId() throws Exception {
        ParkingSeat seat = new ParkingSeat();
        seat.setIsAvailable(1);
        seat.setSequenceNum("34234");
        parkingSeatDao.save(seat);
    }

    @Test
    public void findAllByPage() {
        Page<ParkingSeat> seats = parkingSeatDao.findAll(new PageRequest(1, 5, new Sort("id")));
        Iterator<ParkingSeat> iterator = seats.iterator();
        while (iterator.hasNext()) {
            ParkingSeat seat = iterator.next();
            System.out.println(seat.getId() + "----------------------------------------");
        }
    }

    @Test
    public void saveBatch() {
        for(int i = 1; i < 31; i++) {
            List<ParkingSeat> seats = new ArrayList<>();
            ParkingPlace parkingPlace = new ParkingPlace();
            parkingPlace.setId(i);
            for(int j = 0; j < 31; j++) {
                ParkingSeat parkingSeat = new ParkingSeat();
                parkingSeat.setParkingPlace(parkingPlace);
                parkingSeat.setSequenceNum("sequence:" + j);
                parkingSeat.setIsAvailable(1);
                seats.add(parkingSeat);
            }
            parkingSeatDao.save(seats);
        }
    }

    @Test
    public void find() {
        int id = 1;
        List<ParkingSeat> seats = parkingSeatService.getParkingSeatsByPlaceId(1);
        for(int i = 0; i < seats.size(); i++)
            System.out.println(seats.get(i).getSequenceNum());
    }

    @Test
    public void findByParkingPlaceAndIsAvailableTest() {
        ParkingPlace parkingPlace = new ParkingPlace();
        parkingPlace.setId(0);
        List<ParkingSeat> seats = CommonUtils.toList(parkingSeatDao.findByParkingPlaceAndIsAvailable(parkingPlace, 0));
        for (int i = 0; i < seats.size(); i++) {
            System.out.println(seats.get(i).getSequenceNum());
        }
    }

    @Test
    public void testUpdate() {
        ParkingSeat seat = new ParkingSeat();
        seat.setId(1);
        seat.setIsAvailable(1);
        parkingSeatDao.save(seat);
    }
}