package com.example.service;

import com.example.bean.ParkingPlace;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;

import java.util.List;


/**
 * Created by Administrator on 2017/7/7.
 */
public interface ParkingPlaceService{
    void createParkingPlace(ParkingPlace parkingPlace);
    List<ParkingPlace> getAllPlaces();
    Page<ParkingPlace> getPlacesPage(Specification<ParkingPlace> specification, String order, String direction, String index);
}
