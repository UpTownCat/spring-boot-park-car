package com.example.service.impl;

import com.example.bean.ParkingPlace;
import com.example.dao.ParkingPlaceDao;
import com.example.service.ParkingPlaceService;
import com.example.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by Administrator on 2017/7/7.
 */
@Service
public class ParkingPlaceServiceImpl implements ParkingPlaceService{
    @Autowired
    private ParkingPlaceDao parkingPlaceDao;

    @Override
    public void createParkingPlace(ParkingPlace parkingPlace) {
        parkingPlaceDao.save(parkingPlace);
    }

    @Override
    public List<ParkingPlace> getAllPlaces() {
        return CommonUtils.<ParkingPlace>toList(parkingPlaceDao.findAll());
    }

    @Override
    public Page<ParkingPlace> getPlacesPage(Specification<ParkingPlace> specification, String order, String direction, String index) {
        int page = CommonUtils.getPageIndex(index);
        Sort sort = null;
        if(order != null && order.length() != 0){
            if(direction != null) {
                sort = new Sort(Sort.Direction.DESC, order);
            }else {
                sort = new Sort(order);
            }
        }
        PageRequest pageRequest = new PageRequest(page, 9, sort);
//        ParkingPlaceSpecification specification = null;
//        if(name != null && name.trim().length() != 0) {
//            specification = new ParkingPlaceSpecification();
//            specification.setName(name);
//        }
        return parkingPlaceDao.findAll(specification, pageRequest);
    }
}
