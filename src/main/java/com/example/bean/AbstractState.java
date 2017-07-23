package com.example.bean;

/**
 * Created by Administrator on 2017/7/16.
 */
public abstract class AbstractState {
    protected String name;
    protected ParkingSeat parkingSeat;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ParkingSeat getParkingSeat() {
        return parkingSeat;
    }

    public void setParkingSeat(ParkingSeat parkingSeat) {
        this.parkingSeat = parkingSeat;
    }

//    public void change(i)

    protected abstract void check();
}

