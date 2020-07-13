package com.bosssoft.service.impl;

import com.alibaba.fastjson.JSON;
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
 * @description 申请清单业务层实现类
 */
@Service
public class ApplyOrderServiceImpl implements ApplyOrderService {
    @Autowired
    private ApplyOrderDao applyOrderDao;

    @Autowired
    private ApplyItemDao applyItemDao;

    @Autowired
    private OrderService orderService;

    /**
     * 查询返回出申请表对应信息
     */
    @Override
    public String queryApplyOrder(Long id) {
        ApplyOrder applyOrder = applyOrderDao.queryApplyOrder(id);
        return JSON.toJSONString(applyOrder);
    }

    /**
     * 添加新的申请记录到数据库
     */
    @Override
    public boolean addApplyOrder(ApplyOrder applyOrder) {
        return applyOrderDao.addApplyOrder(applyOrder);
    }

    /**
     * 更新报表信息
     */
    @Override
    public boolean updateApplyOrder(ApplyOrder applyOrder) {
        return applyOrderDao.updateApplyOrder(applyOrder);
    }

    /**
     * 删除报表
     */
    @Override
    public boolean deleteApplyOrder(int id) {
        return applyOrderDao.deleteApplyOrder(id);
    }

    /**
     * 物品申请清单提交时形成申请报表，存入数据库
     */
    @Override
    public void settleOrder(){
        ApplyOrder applyOrder = new ApplyOrder();
        HashMap<Long, ApplyItem> itemlist = orderService.getItemlist();
        /**
         * 部门id
         */
        applyOrder.setOrderId(2020070123L);
        /**
         * 申请部门
         */
        applyOrder.setApplyDepartment("研发部");
        /**
         * 申请时间
         */
        applyOrder.setApplyTime(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()));
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

        /**
         * 遍历itemlist得到物品申请清单出入数据库
         */
        for (Map.Entry<Long,ApplyItem> entry:itemlist.entrySet()){
            ApplyItem item = entry.getValue();
            item.setApplyOrderId(2020070123L);
            applyItemDao.addApplyItem(item);
        }

    }
}
