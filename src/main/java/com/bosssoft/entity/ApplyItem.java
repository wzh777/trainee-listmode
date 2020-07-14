package com.bosssoft.entity;

import lombok.Data;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 物品申请清单实体类
 */
@Data
public class ApplyItem {
    private long id;

    /**
     * 订单号id
     */
    private long applyOrderId;

    /**
     * 物品id
     */
    private long goodsId;

    /**
     * 物品名字
     */
    private String goodsName;

    /**
     * 规格型号
     */
    private String goodsType;

    /**
     * 数量
     */
    private int number;

    /**
     * 用途地点
     */
    private String palace;

    /**
     * 需要时间
     */
    private String usedate;
}
