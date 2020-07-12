package com.bosssoft.service;

import com.bosssoft.entity.ApplyItem;

import java.util.HashMap;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 物品申请清单服务层接口
 */
public interface OrderService {
    /**
     * 添加单条申请记录到物品清单
     */
    boolean add(ApplyItem applyItem);
    /**
     * 删除单条物品申请记录
     */
    boolean remove(Long id);
    /**
     * 修改物品申请记录数量
     */
    boolean editnumber(Long id,int number);
    /**
     * 查询物品申请清单
     */
    String query();
    /**
     * 提交物品清单
     */
    String settle();
    /**
     * 获得物品清单
     */
    HashMap<Long,ApplyItem> getItemlist();
}
