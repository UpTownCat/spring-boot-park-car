package com.example.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/7.
 */
@Entity
public class Owner implements Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String name;

    private String phone;

    private String password;

    private String email;

    private Integer gender;

    private Double balance;

//    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.MERGE}, mappedBy = "owner", fetch = FetchType.EAGER)
//    @Transient
//    private List<Car> cars;

//    public List<Car> getCars() {
//        return cars;
//    }
//
//    public void setCars(List<Car> cars) {
//        this.cars = cars;
//    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getGender() {
        return gender;
    }

    public void setGender(Integer gender) {
        this.gender = gender;
    }

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Owner(String name, String phone, String password, String email, Integer gender, Double balance) {
        this.name = name;
        this.phone = phone;
        this.password = password;
        this.email = email;
        this.gender = gender;
        this.balance = balance;
    }

    public Owner() {
    }
}
