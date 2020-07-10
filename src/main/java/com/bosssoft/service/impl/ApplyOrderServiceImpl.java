package com.bosssoft.service.impl;

import com.bosssoft.dao.ApplyItemDao;
import com.bosssoft.dao.ApplyOrderDao;
import com.bosssoft.entity.ApplyItem;
import com.bosssoft.entity.ApplyOrder;
import com.bosssoft.service.ApplyOrderService;
import com.bosssoft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author 吴志鸿
 * @date 2020/7/10
 * @description
 */
@Service
public class ApplyOrderServiceImpl implements ApplyOrderService {
    @Autowired
    private ApplyOrderDao applyOrderDao;
    @Autowired
    private ApplyItemDao applyItemDao;

    @Autowired
    private OrderService orderService;

    @Override
    public List<ApplyOrder> queryApplyOrder() {
        return applyOrderDao.queryApplyOrder();
    }

    @Override
    public boolean addApplyOrder(ApplyOrder applyOrder) {
        return applyOrderDao.addApplyOrder(applyOrder);
    }

    @Override
    public boolean updateApplyOrder(ApplyOrder applyOrder) {
        return applyOrderDao.updateApplyOrder(applyOrder);
    }

    @Override
    public boolean deleteApplyOrder(int id) {
        return applyOrderDao.deleteApplyOrder(id);
    }

    @Override
    public void settleOrder(){
        ApplyOrder applyOrder = new ApplyOrder();
        HashMap<Long, ApplyItem> itemlist = orderService.getItemlist();

        ApplyItem applyItem = null;

        /**
         * 申请部门
         */
        applyOrder.setApplyDepartment("研发部");
        /**
         * 申请时间
         */
        applyOrder.setApplyTime(new Date());
        /**
         * 申请人
         */
        applyOrder.setApplyName("吴志鸿");
        /**
         * 总经理意见
         */
        applyOrder.setGeneralManagerOpinion("同意");
        /**
         * 矿长审批意见
         */
        applyOrder.setMineManagerOpinion("同意");
        /**
         * 部门审批意见
         */
        applyOrder.setDepartmentOpinion("同意");
        /**
         * 仓库核查意见
         */
        applyOrder.setWarehouseOpinion("同意");
        /**
         * 采购部经办意见
         */
        applyOrder.setProcurementOpinion("同意");
        applyOrderDao.addApplyOrder(applyOrder);

        for (Map.Entry<Long,ApplyItem> entry:itemlist.entrySet()){
            applyItemDao.addApplyItem(entry.getValue());
        }


    }
}
