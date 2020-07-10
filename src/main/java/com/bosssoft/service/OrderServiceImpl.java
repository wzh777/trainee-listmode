package com.bosssoft.service;

import com.alibaba.fastjson.JSON;
import com.bosssoft.entity.ApplyItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private HttpSession session;

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
        return null;
    }

    public HashMap<Long,ApplyItem> getItemlist(){
        itemlist =(HashMap) session.getAttribute("itemlist");
        if(itemlist == null){
            itemlist = new HashMap<Long,ApplyItem>();
            session.setAttribute("itemlist",itemlist);
        }
        return itemlist;
    }
}
