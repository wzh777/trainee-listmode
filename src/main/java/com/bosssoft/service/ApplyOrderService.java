package com.bosssoft.service;

import com.bosssoft.entity.ApplyOrder;

import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/10
 * @description
 */
public interface ApplyOrderService {
    List<ApplyOrder> queryApplyOrder();
    boolean addApplyOrder(ApplyOrder applyOrder);
    boolean updateApplyOrder(ApplyOrder applyOrder);
    boolean deleteApplyOrder(int id);
    void settleOrder();
}
