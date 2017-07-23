package com.example.dao;

import com.example.bean.ParkingPlace;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface ParkingPlaceDao extends JpaSpecificationExecutor<ParkingPlace>, PagingAndSortingRepository<ParkingPlace, Integer> {
}
