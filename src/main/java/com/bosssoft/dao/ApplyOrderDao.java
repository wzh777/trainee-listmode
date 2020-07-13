package com.bosssoft.dao;

import com.bosssoft.entity.ApplyOrder;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;


/**
 * @author 吴志鸿
 * @date 2020/7/9
 * @description 申请报表持久层接口
 */
@Mapper
@Repository
public interface ApplyOrderDao {
    /**
     * 查询返回出申请表对应信息
     */
    ApplyOrder queryApplyOrder(Long id);

    /**
     * 添加新的申请记录到数据库
     */
    boolean addApplyOrder(ApplyOrder applyOrder);

    /**
     * 更新报表信息
     */
    boolean updateApplyOrder(ApplyOrder applyOrder);

    /**
     * 删除报表
     */
    boolean deleteApplyOrder(int id);
}
