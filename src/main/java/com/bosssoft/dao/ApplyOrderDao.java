package com.bosssoft.dao;

import com.bosssoft.entity.ApplyOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 申请报表持久层接口
 */
@Mapper
@Repository
public interface ApplyOrderDao {
    List<ApplyOrder> queryApplyOrder();
    boolean addApplyOrder(ApplyOrder applyOrder);
    boolean updateApplyOrder(ApplyOrder applyOrder);
    boolean deleteApplyOrder(int id);
}
