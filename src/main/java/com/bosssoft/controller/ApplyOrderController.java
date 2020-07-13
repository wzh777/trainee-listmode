package com.bosssoft.controller;

import com.bosssoft.entity.ApplyOrder;
import com.bosssoft.service.ApplyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


/**
 * @author 吴志鸿
 * @date 2020/7/10
 * @description 物品申请清单controller层
 */
@RestController
@RequestMapping("/applyorder")
public class ApplyOrderController {

    @Autowired
    private ApplyOrderService applyOrderService;

    /**
     * 查询返回出申请表对应信息
     */
    @GetMapping("/query")
    public String query(@RequestBody ApplyOrder applyOrder) {
        return applyOrderService.queryApplyOrder(applyOrder.getId());
    }
}
