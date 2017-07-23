package com.example.bean;

import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2017/7/16.
 */
@Component
public class ParkingCostStrategy implements Strategy {
    @Override
    public double calculateCost(int hour, double moneyPerHour) {
        double result = hour * moneyPerHour;
        String format = String.format("%.3f", result);
        return Double.parseDouble(format);
    }
}
