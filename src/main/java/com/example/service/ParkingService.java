package com.example.service;

import com.example.bean.Parking;
import com.example.bean.ParkingSeat;
import com.example.bean.specification.ParkingSpecification;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
public interface ParkingService {
    List<Parking> getParkingsByOwnerId(int id);
    List<Parking> getAllParkings();
    Page<Parking> getParkingsPage(ParkingSpecification specification, String index, String order, String direction);
    void createParking(Parking parking, ParkingSeat parkingSeat);
}
