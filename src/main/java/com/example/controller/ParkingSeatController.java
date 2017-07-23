package com.example.controller;

import com.example.bean.ParkingSeat;
import com.example.dto.StateDto;
import com.example.service.ParkingPlaceService;
import com.example.service.ParkingSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/16.
 */
@Controller
@RequestMapping("/seats")
public class ParkingSeatController {
    @Autowired
    private ParkingSeatService parkingSeatService;
    @Autowired
    private ParkingPlaceService parkingPlaceService;

    @GetMapping("/")
    public String getAddSeatView(Map<String, Object> map) {
        map.put("places", parkingPlaceService.getAllPlaces());
        return "/seat/seat_add";
    }

    @PostMapping("/")
    @ResponseBody
    public StateDto createParkingSeat(ParkingSeat parkingSeat) {
        StateDto stateDto = new StateDto();
        parkingSeatService.createSeat(parkingSeat);
        stateDto.setState(true);
        return stateDto;
    }

}
