package com.example.controller;

import com.example.bean.ParkingPlace;
import com.example.bean.ParkingSeat;
import com.example.bean.specification.ParkingPlaceSpecification;
import com.example.dto.StateDto;
import com.example.service.ParkingPlaceService;
import com.example.service.ParkingSeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/7.
 */
@Controller
@RequestMapping("/places")
public class ParkingPlaceController {

    @Autowired
    private ParkingPlaceService parkingPlaceService;
    @Autowired
    private ParkingSeatService parkingSeatService;

    /**
     * 进入添加停车场的视图
     * @return
     */
    @GetMapping("/")
    public String getAddPlaceView() {
        return "/places/place_add";
    }

    /**
     * 添加停车场
     * @param parkingPlace
     * @return
     */
    @PostMapping("/")
    @ResponseBody
    public StateDto createParkingPlace(ParkingPlace parkingPlace) {
        parkingPlaceService.createParkingPlace(parkingPlace);
        return new StateDto(true, "");
    }

    /**
     * 显示停车列表
     * @param index
     * @param order
     * @param specification
     * @param map
     * @return
     */
    @GetMapping("/list")
    public String listPlaces(String index, String order, ParkingPlaceSpecification specification, Map<String, Object> map) {
        PageRequest pageRequest = new PageRequest(1, 9, null);
        String parseOder = null;
        String direction = null;
        if(order != null) {
            if(order.equals("1"))
                parseOder = "moneyPerHour";
            if(order.equals("2")) {
                parseOder = "moneyPerHour";
                direction = "desc";
            }
        }
        Page<ParkingPlace> page = parkingPlaceService.getPlacesPage(specification, parseOder, direction, index);
        List<ParkingPlace> places = page.getContent();
        for (int i = 0; i < places.size(); i++) {
            places.get(i).setAvailableSize(parkingSeatService.getAvailableSeatsCount(places.get(i).getId()));
        }
        map.put("page",page);
        map.put("specification", specification);
        map.put("order", order);
        return "/places/place_list";
    }

    @GetMapping("/{id}/seats")
    public String listParkingSeats(@PathVariable Integer id, String index, Map<String, Object> map) {
        Page<ParkingSeat> page = parkingSeatService.getSeatsPageByPlaceId(id, index);
        map.put("page", page);
        return "/seat/seat_list";
    }
}
