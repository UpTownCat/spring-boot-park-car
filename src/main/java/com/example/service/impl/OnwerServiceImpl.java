package com.example.service.impl;

import com.example.bean.Owner;
import com.example.dao.OwnerDao;
import com.example.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/7/7.
 */
@Service
public class OnwerServiceImpl implements OwnerService{
    @Autowired
    private OwnerDao ownerDao;
    @Override
    public boolean validateOwner(String phone, String password) {
        Owner owner = ownerDao.findByPhone(phone);
        if(owner.getPassword().equals(password)) {
            return true;
        }
        return false;
    }

    @Override
    public Owner getOwnerById(Integer id) {
        return ownerDao.findOne(id);
    }

    @Override
    public Owner getOwnerByPhone(String phone) {
        return ownerDao.findByPhone(phone);
    }
}
