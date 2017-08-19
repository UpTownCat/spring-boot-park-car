package com.example.dao;

import com.example.App;
import com.example.bean.Car;
import com.example.bean.Owner;
import com.example.bean.Parking;
import com.example.bean.ParkingPlace;
import com.example.service.ParkingService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = App.class)
public class ParkingDaoTest {

    @Autowired
    private ParkingDao parkingDao;
    @Autowired
    private ParkingService parkingService;

    @Test
    public void save() {
        for (int i = 0; i < 1; i++) {
            Parking parking = new Parking();
            parking.setInTime(new Date());
            parking.setPrice(200.0);
            Car car = new Car();
            car.setId(21);
            parking.setCar(car);
            Owner owner = new Owner();
            owner.setId(1);
            parking.setOwner(owner);
            ParkingPlace parkingPlace = new ParkingPlace();
            parkingPlace.setId(1);
            parking.setParkingPlace(parkingPlace);
            parkingDao.save(parking);
            System.out.println(parking.getId() + "----------------------------------");
        }
    }

    @Test
    public void get() {
        Owner owner = new Owner();
        owner.setId(1);
        List<Parking> parkings = parkingService.getParkingsByOwnerId(1);
        for (int i = 0; i < parkings.size(); i++) {
            Parking parking = parkings.get(i);
            System.out.println(parking.getCar().getPlate());
            System.out.println(parking.getOwner().getName());
            System.out.println(parking.getParkingPlace().getName());
        }
    }

    @Test
    public void getByPage() {
        PageRequest pageRequest = new PageRequest(0, 5, new Sort("id"));
        Page<Parking> page = parkingDao.findAll(pageRequest);
        List<Parking> parkings = page.getContent();
        int totalPages = page.getTotalPages();
        int number = page.getNumber();
        long totalElements = page.getTotalElements();
        int numberOfElements = page.getNumberOfElements();
        int size = page.getSize();
        System.out.println("totalPages: " + totalPages + "  number: " + number + "  totalElements: "
                + totalElements + "  numberOfElements" + numberOfElements + "   num" + size);
        for (int i = 0; i < parkings.size(); i++) {
            System.out.println(parkings.get(i).getId() + "  ------------------");
        }
    }

}