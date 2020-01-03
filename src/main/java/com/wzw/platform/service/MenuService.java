package com.wzw.platform.service;

import com.wzw.platform.model.entity.MenuEntity;

import java.util.List;

public interface MenuService {
    /**
     * 得到菜单List
     *
     * @param id
     * @return
     */
    List<MenuEntity> menuList(int id);

    /**
     * 获取menus列表
     * @param pageSize
     * @param start
     * @param menuId
     * @return
     */
    List<MenuEntity> menusList(int pageSize, int start, String menuId);

    /**
     * 获取menus列表的总量
     * @param pageSize
     * @param start
     * @param menuId
     * @return
     */
    Integer menusSize(int pageSize, int start, String menuId);
    /**
     * 通过parentId得到menus列表
     *
     * @param parentId
     * @return
     */
    List<MenuEntity> menusByParentId(int parentId);

}
