package com.wzw.platform.dao;

import com.wzw.platform.model.entity.RelationEntity;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RelationDao {

    /**
     * 通过userID 得到关系list
     * @param userId
     * @return
     */
    List<RelationEntity> getRelationByUserId(@Param("userId") int userId);

    /**
     * 通过userID 删除关系
     * @param userId
     */
    void delById(@Param("userId") int userId);

    /**
     * 批量插入关系
     * @param relationList
     */
    void insertRelations(List<RelationEntity> relationList);
}
