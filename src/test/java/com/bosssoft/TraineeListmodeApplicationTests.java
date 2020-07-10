package com.bosssoft;

import com.bosssoft.dao.ApplyOrderDao;
import com.bosssoft.entity.ApplyOrder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;


@SpringBootTest
class TraineeListmodeApplicationTests {
    @Autowired
    ApplyOrderDao applyOrderDao;

    @Test
    public void test(){
        List<ApplyOrder> applyOrders = applyOrderDao.queryApplyOrder();
        System.out.println(applyOrders);
    }
}
