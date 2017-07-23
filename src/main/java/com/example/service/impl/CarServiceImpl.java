package com.example.service.impl;

import com.example.bean.Car;
import com.example.bean.Owner;
import com.example.dao.CarDao;
import com.example.service.CarService;
import com.example.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
@Service
public class CarServiceImpl implements CarService {
    @Autowired
    private CarDao carDao;
    @Override
    public void createCar(Car car) {
        carDao.save(car);
    }

    @Override
    public List<Car> getCarsByOwnerId(int id) {
        Owner owner = new Owner();
        owner.setId(id);
        Iterable<Car> carsIterable = carDao.findByOwner(owner);
        return CommonUtils.toList(carsIterable);
    }
}
