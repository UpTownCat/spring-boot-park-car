package com.example.service;

import com.example.bean.Car;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface CarService {
    void createCar(Car car);
    List<Car> getCarsByOwnerId(int id);
}
