package com.example.bean.specification;

import com.example.bean.ParkingPlace;
import com.example.bean.ParkingSeat;
import com.example.util.CommonUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

/**
 * Created by Administrator on 2017/7/21.
 */
public class ParkingSeatSpecification implements Specification<ParkingSeat> {
    private String placeId;
    @Override
    public Predicate toPredicate(Root<ParkingSeat> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(!CommonUtils.isEmpty(placeId)) {
            ParkingPlace parkingPlace = new ParkingPlace();
            parkingPlace.setId(Integer.parseInt(placeId));
            Path<ParkingPlace> parkingPlacePath = root.get("parkingPlace");
            query.where(cb.equal(parkingPlacePath, parkingPlace));
        }
        return null;
    }

    public String getPlaceId() {
        return placeId;
    }

    public void setPlaceId(String placeId) {
        this.placeId = placeId;
    }
}
