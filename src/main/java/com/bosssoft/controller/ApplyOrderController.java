package com.bosssoft.controller;

import com.alibaba.fastjson.JSON;
import com.bosssoft.entity.ApplyOrder;
import com.bosssoft.service.ApplyOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/10
 * @description
 */
@RestController
@RequestMapping("/applyorder")
public class ApplyOrderController {

    @Autowired
    private ApplyOrderService applyOrderService;
    @Autowired
    private HttpSession session;
    @RequestMapping("/add")
    public String add(@RequestBody ApplyOrder applyOrder){
        applyOrderService.addApplyOrder(applyOrder);
        session.setAttribute("applyOrder",applyOrder);
        return "1";
    }
    @RequestMapping("/query")
    public String query(){
        return applyOrderService.queryApplyOrder();
    }
}
