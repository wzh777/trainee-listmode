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
    /**
     * 查询物品清单
     */
    List<ApplyItem> queryApplyItem();
    /**
     * 添加物品清单
     */
    boolean addApplyItem(ApplyItem applyItem);
    /**
     * 修改物品清单
     */
    boolean updateApplyItem(ApplyItem applyItem);
    /**
     * 删除物品清单
     */
    boolean deleteApplyItem(int id);
}
