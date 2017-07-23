package com.example.bean;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/7/7.
 */
@Entity
public class ParkingPlace {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String location;

    private Double moneyPerHour;

    @Transient
    private Integer availableSize;

//    @OneToMany(targetEntity = ParkingSeat.class, cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "parkingPlace", fetch = FetchType.EAGER)
//    private List<ParkingSeat> parkingSeats;


    public Integer getAvailableSize() {
        return availableSize;
    }

    public void setAvailableSize(Integer availableSize) {
        this.availableSize = availableSize;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Double getMoneyPerHour() {
        return moneyPerHour;
    }

    public void setMoneyPerHour(Double moneyPerHour) {
        this.moneyPerHour = moneyPerHour;
    }

//    public List<ParkingSeat> getParkingSeats() {
//        return parkingSeats;
//    }
//
//    public void setParkingSeats(List<ParkingSeat> parkingSeats) {
//        this.parkingSeats = parkingSeats;
//    }
}
