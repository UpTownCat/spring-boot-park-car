package com.example.controller;

import com.example.bean.Car;
import com.example.bean.Owner;
import com.example.bean.Parking;
import com.example.bean.specification.ParkingSpecification;
import com.example.dto.StateDto;
import com.example.service.CarService;
import com.example.service.OwnerService;
import com.example.service.ParkingService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2017/7/7.
 */
@Controller
@RequestMapping("/owners")
public class OwnerController {
    @Autowired
    private OwnerService ownerService;
    @Autowired
    private CarService carService;
    @Autowired
    private ParkingService parkingService;

    /**
     * 获取用户个人的信息
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/{id}")
    public String getOwnerDetails(@PathVariable Integer id, Map<String, Owner> map) {
        Owner owner = ownerService.getOwnerById(id);
        map.put("owner", owner);
        return "/owners/owner_detail";
    }

    /**
     * 获取用户个人的车辆
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/{id}/cars")
    public String getOwnerCars(@PathVariable Integer id, Map<String, Object> map) {
        List<Car> cars = carService.getCarsByOwnerId(id);
        map.put("cars", cars);
        return "/car/car_list";
    }

    /**
     * 获取用户个人的停车记录
     * @param id
     * @param map
     * @return
     */
    @GetMapping("/{id}/parkings")
    public String getParkings(@PathVariable Integer id, String index, String order, ParkingSpecification specification, Map<String, Object> map) {
        Owner owner = new Owner();
        owner.setId(id);
        specification.setOwner(owner);
        Page<Parking> page = parkingService.getParkingsPage(specification, index, order, null);
        map.put("page", page);
        map.put("specification", specification);
        return "/parking/parking_list";
    }

    /**
     * 用户登陆
     * @param phone
     * @param password
     * @return
     */
    @PostMapping("/login")
    @ResponseBody
    public String login(String phone, String password) {
        UsernamePasswordToken token = new UsernamePasswordToken(phone, password);
        Subject subject = SecurityUtils.getSubject();
        try {
            subject.login(token);
        }catch (Exception e) {
            return "redirect:/login";
        }
        return "redirect:/parkings/list?owner.id=1";
    }
}
