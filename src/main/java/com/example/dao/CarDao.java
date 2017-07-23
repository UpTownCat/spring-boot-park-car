package com.example.dao;

import com.example.bean.Car;
import com.example.bean.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface CarDao extends CrudRepository<Car, Integer> {
    Iterable<Car> findByOwner(Owner owner);
}
