package com.example.bean.specification;

import com.example.bean.Owner;
import com.example.bean.Parking;
import com.example.util.CommonUtils;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/7/21.
 */
public class ParkingSpecification  implements Specification<Parking>{
    private Owner owner;
    private String left;
    private String right;

    @Override
    public Predicate toPredicate(Root<Parking> root, CriteriaQuery<?> query, CriteriaBuilder cb) {
        if(!CommonUtils.isEmpty(owner.getId() + "")) {
            Path<Owner> ownerIdPath = root.get("owner");
            query.where(cb.equal(ownerIdPath, owner));
        }
        Date l = CommonUtils.toDate(left);
        Date r = CommonUtils.toDate(right);
        if(l == null && r != null) {
            Path<Date> outTimePath = root.get("out_time");
            query.where(cb.lessThanOrEqualTo(outTimePath, r));
        }
        if(l != null && r == null) {
            Path<Date> outTimePath = root.get("out_time");
            query.where(cb.greaterThanOrEqualTo(outTimePath, l));
        }
        if(l != null && r != null) {
            Path<Date> outTimePath = root.get("out_time");
            query.where(cb.between(outTimePath, l, r));
        }
        return null;
    }

    public Owner getOwner() {
        return owner;
    }

    public void setOwner(Owner owner) {
        this.owner = owner;
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
