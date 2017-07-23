package com.example.bean.specification;

import com.example.bean.ParkingPlace;
import com.example.util.CommonUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by Administrator on 2017/7/21.
 */
public class ParkingPlaceSpecification implements Specification<ParkingPlace> {

    private String name;
    private String location;
    private String left;
    private String right;

    @Override
    public Predicate toPredicate(Root<ParkingPlace> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(!CommonUtils.isEmpty(name)) {
            Path<String> namePath = root.get("name");
            query.where(cb.like(namePath, "%" + name + "%"));
        }
        if(!CommonUtils.isEmpty(location)) {
            Path<String> locationPath = root.get("location");
            query.where(cb.like(locationPath, "%" + location + "%"));
        }
        if(!CommonUtils.isEmpty(left) && CommonUtils.isEmpty(right)) {
            Path<Double> moneyPerHourPath = root.get("moneyPerHour");
            query.where(cb.greaterThanOrEqualTo(moneyPerHourPath, Double.parseDouble(left)));
        }

        if(CommonUtils.isEmpty(left) && !CommonUtils.isEmpty(right)) {
            Path<Double> moneyPerHourPath = root.get("moneyPerHour");
            query.where(cb.lessThanOrEqualTo(moneyPerHourPath, Double.parseDouble(right)));
        }

        if(!CommonUtils.isEmpty(left) && !CommonUtils.isEmpty(right)) {
            Path<Double> moneyPerHourPath = root.get("moneyPerHour");
            query.where(cb.between(moneyPerHourPath, Double.parseDouble(left), Double.parseDouble(right)));
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public ParkingPlaceSpecification() {
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

    public String getLeft() {
        return left;
    }

    public void setLeft(String left) {
        this.left = left;
    }

    public String getRight() {
        return right;
    }

    public void setRight(String right) {
        this.right = right;
    }
}
