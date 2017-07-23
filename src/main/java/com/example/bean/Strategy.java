package com.example.bean;

/**
 * Created by Administrator on 2017/7/16.
 */
public interface Strategy {
    /**
     * 处理计时停车费
     * @param hour
     * @param moneyPerHour
     * @return
     */
    double calculateCost(int hour, double moneyPerHour);
}
