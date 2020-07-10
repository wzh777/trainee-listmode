package com.bosssoft.entity;

import lombok.Data;

import java.util.Date;
import java.util.HashMap;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 申请报表实体类
 */
@Data
public class ApplyOrder {
    private Long id;
    /**
     * 申请部门
     */
    private String applyDepartment;
    /**
     * 申请时间
     */
    private Date applyTime;
    /**
     * 申请人
     */
    private String applyName;
    /**
     * 总经理意见
     */
    private String generalManagerOpinion;
    /**
     * 矿长审批意见
     */
    private String mineManagerOpinion;
    /**
     * 部门审批意见
     */
    private String departmentOpinion;
    /**
     * 仓库核查意见
     */
    private String warehouseOpinion;
    /**
     * 采购部经办意见
     */
    private String procurementOpinion;
    /**
     * 物品申请清单列表
     */
    private HashMap<Long, ApplyItem> Items;
}
