package com.bosssoft.service;

import com.bosssoft.entity.ApplyOrder;


/**
 * @author 吴志鸿
 * @date 2020/7/10
 * @description 申请清单业务层接口
 */
public interface ApplyOrderService {
    /**
     * 查询返回出申请表对应信息
     */
    String queryApplyOrder(Long id);
    /**
     * 添加新的申请记录到数据库
     */
    boolean addApplyOrder(ApplyOrder applyOrder);
    /**
     * 更新报表信息
     */
    boolean updateApplyOrder(ApplyOrder applyOrder);
    /**
     * 删除报表
     */
    boolean deleteApplyOrder(int id);
    /**
     * 物品申请清单提交时形成申请报表，存入数据库
     */
    void settleOrder();
}
