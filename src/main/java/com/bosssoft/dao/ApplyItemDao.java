package com.bosssoft.dao;

import com.bosssoft.entity.ApplyItem;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 物品申请清单持久层操作
 */
@Mapper
@Repository
public interface ApplyItemDao {
    List<ApplyItem> queryApplyItem();
    boolean addApplyItem(ApplyItem applyItem);
    boolean updateApplyItem(ApplyItem applyItem);
    boolean deleteApplyItem(int id);
}
