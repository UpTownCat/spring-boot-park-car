package com.example.service;

import com.example.bean.ParkingSeat;
import org.springframework.data.domain.Page;

import java.util.List;

/**
 * Created by Administrator on 2017/7/15.
 */
public interface ParkingSeatService {
    void createSeat(ParkingSeat parkingSeat);
    List<ParkingSeat> getParkingSeatsByPlaceId(int id);
    int getAvailableSeatsCount(int placeId);
    Page<ParkingSeat> getSeatsPageByPlaceId(int id, String index);
    ParkingSeat getSeatById(int id);
}
