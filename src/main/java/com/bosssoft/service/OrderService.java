package com.bosssoft.service;

import com.bosssoft.entity.ApplyItem;

import java.util.HashMap;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description
 */
public interface OrderService {
    boolean add(ApplyItem applyItem);
    boolean remove(Long id);
    boolean editnumber(Long id,int number);
    String query();
    String settle();
    HashMap<Long,ApplyItem> getItemlist();
}
