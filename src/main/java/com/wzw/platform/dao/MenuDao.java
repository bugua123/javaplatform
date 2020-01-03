package com.wzw.platform.dao;

import com.wzw.platform.model.entity.MenuEntity;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface MenuDao {


    /**
     * 获取menus列表
     *
     * @param pageSize
     * @param start
     * @param menuId
     * @return
     */
    List<MenuEntity> menusList(@Param("pageSize") int pageSize, @Param("start") int start,
                               @Param("menuId") String menuId);
    /**
     * 获取menus列表的总量
     *
     * @param pageSize
     * @param start
     * @param menuId
     * @return
     */
    Integer menusSize(@Param("pageSize") int pageSize, @Param("start") int start,
                      @Param("menuId") String menuId);

    /**
     * 通过parentId得到menus列表
     *
     * @param parentId
     * @return
     */
    List<MenuEntity> menusByParentId(@Param("parentId") int parentId);
}
