package com.example.dao;

import com.example.bean.Owner;
import com.example.bean.Parking;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by Administrator on 2017/7/20.
 */
public interface ParkingDao extends JpaSpecificationExecutor<Parking>, PagingAndSortingRepository<Parking, Integer> {
    Iterable<Parking> findByOwner(Owner owner);
}
