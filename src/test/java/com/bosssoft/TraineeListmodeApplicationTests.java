package com.bosssoft;

import com.bosssoft.dao.ApplyItemDao;
import com.bosssoft.dao.ApplyOrderDao;
import com.bosssoft.entity.ApplyItem;
import com.bosssoft.entity.ApplyOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class TraineeListmodeApplicationTests {


    @Autowired
    private ApplyOrderDao applyOrderDao;
    @Test
    void contextLoads() {
        List<ApplyOrder> applyOrders = applyOrderDao.queryApplyOrder();
        System.out.println(applyOrders);
    }
}
