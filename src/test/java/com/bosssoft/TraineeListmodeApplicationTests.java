package com.bosssoft;

import com.bosssoft.dao.ApplyItemDao;
import com.bosssoft.dao.ApplyOrderDao;
import com.bosssoft.entity.ApplyItem;
import com.bosssoft.entity.ApplyOrder;
import com.bosssoft.service.ApplyOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
class TraineeListmodeApplicationTests {


    @Autowired
    private ApplyOrderDao applyOrderDao;
    @Autowired
    private ApplyOrderService applyOrderService;
    @Test
    void contextLoads() {
        applyOrderService.settleOrder();
    }
}
