package com.bosssoft.controller;

import com.bosssoft.entity.ApplyItem;
import com.bosssoft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description
 */
@RestController
public class OrderController {
    @Autowired
    private OrderService orderService;

    @RequestMapping("/add")
    public String add(@RequestBody ApplyItem applyItem){
        orderService.add(applyItem);
        return "add applyitem info:" + applyItem.getGoodsName();
    }

    @RequestMapping("/remove")
    public String remove(@RequestBody ApplyItem applyItem){
        orderService.remove(applyItem.getId());
        return "remove applyitem info:" + applyItem.getId();
    }

    @RequestMapping("/editnumber")
    public String editnumber(@RequestBody ApplyItem applyItem){
        if(orderService.editnumber(applyItem.getId(), applyItem.getNumber())) {
            return "editnumber success!";
        }else {
            return "editnumber failed!";
        }
    }

    @RequestMapping("/list")
    public String list(){
        return orderService.query();
    }
}
