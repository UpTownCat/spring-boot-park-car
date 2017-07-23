package com.example.dao;

import com.example.bean.ParkingPlace;
import com.example.bean.ParkingSeat;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface ParkingSeatDao extends JpaSpecificationExecutor, PagingAndSortingRepository<ParkingSeat, Integer> {
    Iterable<ParkingSeat> findByParkingPlace(ParkingPlace parkingPlace);
    Iterable<ParkingSeat> findByParkingPlaceAndIsAvailable(ParkingPlace parkingPlace, Integer isAvailable);
}
