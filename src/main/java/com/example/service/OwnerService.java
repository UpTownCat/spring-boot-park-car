package com.example.service;

import com.example.bean.Owner;

import javax.websocket.OnError;
import java.io.Serializable;

/**
 * Created by Administrator on 2017/7/7.
 */
public interface OwnerService {
    /**
     * 根据手机号码查找用户
     * @param phone
     * @param password
     * @return
     */
    boolean validateOwner(String phone, String password);

    /**
     * 根据id查找用户
     * @param id
     * @return
     */
    Owner getOwnerById(Integer id);

    /**
     * 根据手机号获取用户
     * @param phone
     * @return
     */
    Owner getOwnerByPhone(String phone);
}
