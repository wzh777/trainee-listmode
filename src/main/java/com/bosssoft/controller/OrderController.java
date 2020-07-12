package com.bosssoft.controller;

import com.bosssoft.entity.ApplyItem;
import com.bosssoft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 申请报表controller层
 */
@RestController
@RequestMapping("/order")
public class OrderController {
    @Autowired
    private OrderService orderService;

    @PostMapping("/add")
    public String add(@RequestBody ApplyItem applyItem){
        orderService.add(applyItem);
        return "add applyitem success, info:" + applyItem;
    }

    @PostMapping("/remove")
    public String remove(@RequestBody ApplyItem applyItem){
        orderService.remove(applyItem.getId());
        return "remove applyitem info:" + applyItem.getId();
    }

    @PostMapping("/editnumber")
    public String editnumber(@RequestBody ApplyItem applyItem){
        if(orderService.editnumber(applyItem.getId(), applyItem.getNumber())) {
            return "editnumber success!";
        }else {
            return "editnumber failed!";
        }
    }

    @GetMapping("/list")
    public String list(){
        return orderService.query();
    }

    @GetMapping("/settle")
    public String settle(){
        return orderService.settle();
    }
}
