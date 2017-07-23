package com.example.dao;

import com.example.bean.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface OwnerDao extends CrudRepository<Owner, Integer> {
    Owner findByPhone(String phone);
}
