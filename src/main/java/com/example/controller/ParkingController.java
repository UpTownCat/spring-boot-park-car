package com.example.controller;

import com.example.bean.Parking;
import com.example.bean.ParkingSeat;
import com.example.bean.specification.ParkingSpecification;
import com.example.config.MyRedisPool;
import com.example.dto.StateDto;
import com.example.service.ParkingSeatService;
import com.example.service.ParkingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * Created by Administrator on 2017/7/20.
 */
@Controller
@RequestMapping("/parkings")
public class ParkingController {
    @Autowired
    MyRedisPool redisPool;
    @Autowired
    private ParkingService parkingService;
    @Autowired
    private ParkingSeatService parkingSeatService;

    @GetMapping("/list")
    public String listParkings(ParkingSpecification specification, String index, String order, Map<String, Object> map) {
        Page<Parking> page = parkingService.getParkingsPage(specification, index, order, null);
        map.put("page", page);
        return "parking/parking_list2";
    }

    @PostMapping("/")
    @ResponseBody
    public StateDto createParking(Parking parking, @ModelAttribute ParkingSeat parkingSeat, Integer seatId) {
        StateDto stateDto = new StateDto();
        parkingSeat.setId(seatId);
        System.out.println(seatId + "--------------" + parkingSeat.getIsAvailable());
        parkingService.createParking(parking, parkingSeat);
        stateDto.setState(true);
        return stateDto;
    }

    @ModelAttribute
    public ParkingSeat getSeatModel(@RequestParam(value = "seatId", required = false) Integer seatId) {
        if(seatId == null) {
            return new ParkingSeat();
        }
        return parkingSeatService.getSeatById(seatId);
    }

}
