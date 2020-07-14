package com.bosssoft.controller;

import com.bosssoft.entity.ApplyItem;
import com.bosssoft.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 申请报表controller层
 */
@Slf4j
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    /**
     * 添加单条申请记录到物品清单
     */
    @PostMapping("/add")
    public String add(@RequestBody ApplyItem applyItem) {
        orderService.add(applyItem);
        return "add applyitem success, info:" + applyItem;
    }

    /**
     * 删除单条物品申请记录
     */
    @PostMapping("/remove")
    public String remove(@RequestBody ApplyItem applyItem) {
        orderService.remove(applyItem.getId());
        return "remove applyitem info:" + applyItem.getId();
    }

    /**
     * 修改物品申请记录数量
     */
    @PostMapping("/editnumber")
    public String editnumber(@RequestBody ApplyItem applyItem) {
        if (orderService.editnumber(applyItem.getId(), applyItem.getNumber())) {
            return "editnumber success!";
        } else {
            return "editnumber failed!";
        }
    }

    /**
     * 查询物品申请清单
     */
    @GetMapping("/list")
    public String list() {
        return orderService.query();
    }

    /**
     * 提交物品清单
     */
    @GetMapping("/settle")
    public String settle() {
        return "settle success,order id = " + orderService.settle();
    }
}
