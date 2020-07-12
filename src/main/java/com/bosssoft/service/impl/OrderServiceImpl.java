package com.bosssoft.service.impl;

import com.alibaba.fastjson.JSON;
import com.bosssoft.entity.ApplyItem;
import com.bosssoft.service.ApplyOrderService;
import com.bosssoft.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 物品申请清单服务层实现类
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private HttpSession session;
    @Autowired
    private ApplyOrderService applyOrderService;

    /**
     * 模拟物品申请清单
     */
    private HashMap<Long,ApplyItem> itemlist;

    @Override
    public boolean add(ApplyItem applyItem) {
        getItemlist();
        itemlist.put(applyItem.getId(),applyItem);
        getItemlist();
        return true;
    }

    @Override
    public boolean remove(Long id) {
        getItemlist();
        itemlist.remove(id);
        return true;
    }

    @Override
    public boolean editnumber(Long id, int number) {
        getItemlist();
        ApplyItem applyItem = itemlist.get(id);
        applyItem.setNumber(number);
        return true;
    }

    @Override
    public String query() {
        getItemlist();
        return JSON.toJSONString(itemlist.entrySet().toString());
    }

    @Override
    public String settle() {
        applyOrderService.settleOrder();
        return null;
    }

    @Override
    public HashMap<Long,ApplyItem> getItemlist(){
        itemlist =(HashMap) session.getAttribute("itemlist");
        if(itemlist == null){
            itemlist = new HashMap<>();
            session.setAttribute("itemlist",itemlist);
        }
        return itemlist;
    }
}
