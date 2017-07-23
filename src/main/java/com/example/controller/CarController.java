package com.example.controller;

import com.example.bean.Car;
import com.example.bean.Owner;
import com.example.dto.StateDto;
import com.example.service.CarService;
import com.example.util.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by Administrator on 2017/7/15.
 */
@Controller
@RequestMapping("/cars")
public class CarController {
    @Autowired
    private CarService carService;

    /**
     * 显示添加车辆的视图
     * @return
     */
    @GetMapping("/")
    public String getAddCarView() {
        return "/car/car_add";
    }

    /**
     * 保存车辆
     * @param car
     * @param p
     * @return
     */
    @PostMapping("/")
    @ResponseBody
    public StateDto createCar(Car car, MultipartFile p) {
        StateDto stateDto = new StateDto();
        if(car.getOwner() == null || car.getOwner().getId() == null) {
            Owner owner = new Owner();
            owner.setId(1);
            car.setOwner(owner);
        }
        String filename = "";
        try {
            filename = CommonUtils.savePhoto("F:\\photo\\", p);
        } catch (IOException e) {
            stateDto.setState(false);
            stateDto.setMessage("保存照片失败！");
            return stateDto;
        }
        car.setPhoto(filename);
        carService.createCar(car);
        stateDto.setState(true);
        return stateDto;
    }
}
