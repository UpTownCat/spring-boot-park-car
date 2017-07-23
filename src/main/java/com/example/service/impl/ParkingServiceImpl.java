package com.example.service.impl;

import com.example.bean.Owner;
import com.example.bean.Parking;
import com.example.bean.ParkingSeat;
import com.example.bean.specification.ParkingSpecification;
import com.example.dao.ParkingDao;
import com.example.dao.ParkingSeatDao;
import com.example.service.ParkingService;
import com.example.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by Administrator on 2017/7/20.
 */
@Service
public class ParkingServiceImpl implements ParkingService {
    @Autowired
    private ParkingDao parkingDao;
    @Autowired
    private ParkingSeatDao parkingSeatDao;

    @Override
    public List<Parking> getParkingsByOwnerId(int id) {
        Owner owner = new Owner();
        owner.setId(id);
        return CommonUtils.toList(parkingDao.findByOwner(owner));
    }

    @Override
    public List<Parking> getAllParkings() {
        return CommonUtils.toList(parkingDao.findAll());
    }

    @Override
    public Page<Parking> getParkingsPage(ParkingSpecification specification, String index, String order, String direction) {
        int page = CommonUtils.getPageIndex(index);
        Sort sort = null;
        if(order != null && order.length() != 0)
            sort = new Sort(order);
        PageRequest pageRequest = new PageRequest(page, 5, sort);
        Page<Parking> p = parkingDao.findAll(specification, pageRequest);
        return p;
    }

    @Override
    @Transactional
    public void createParking(Parking parking, ParkingSeat parkingSeat) {
        parking.setInTime(new Date());
        parkingSeat.setIsAvailable(0);
        parkingDao.save(parking);
        parkingSeatDao.save(parkingSeat);
    }
}
