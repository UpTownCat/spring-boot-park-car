package com.example.service.impl;

import com.example.bean.ParkingPlace;
import com.example.bean.ParkingSeat;
import com.example.bean.specification.ParkingSeatSpecification;
import com.example.dao.ParkingSeatDao;
import com.example.service.ParkingSeatService;
import com.example.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
@Service
public class ParkingSeatServiceImpl implements ParkingSeatService {
    @Autowired
    private ParkingSeatDao parkingSeatDao;
    @Override
    public void createSeat(ParkingSeat parkingSeat) {
        parkingSeatDao.save(parkingSeat);
    }

    @Override
    public List<ParkingSeat> getParkingSeatsByPlaceId(int id) {
        ParkingPlace parkingPlace = new ParkingPlace();
        parkingPlace.setId(id);
        return CommonUtils.toList(parkingSeatDao.findByParkingPlace(parkingPlace));
//        return null;
    }

    @Override
    public int getAvailableSeatsCount(int placeId) {
        ParkingPlace parkingPlace = new ParkingPlace();
        parkingPlace.setId(placeId);
        return CommonUtils.toList(parkingSeatDao.findByParkingPlaceAndIsAvailable(parkingPlace, 1)).size();
    }

    @Override
    public Page<ParkingSeat> getSeatsPageByPlaceId(int id, String index) {
        ParkingSeatSpecification specification = new ParkingSeatSpecification();
        specification.setPlaceId(id + "");
        int page = CommonUtils.getPageIndex(index);
        PageRequest pageRequest = new PageRequest(page, 20, null);
        return parkingSeatDao.findAll(specification, pageRequest);
    }

    @Override
    public ParkingSeat getSeatById(int id) {
        return parkingSeatDao.findOne(id);
    }
}
