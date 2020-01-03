package com.wzw.platform.service.impl;

import com.wzw.platform.dao.MenuDao;
import com.wzw.platform.model.entity.MenuEntity;
import com.wzw.platform.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("menuServiceImpl")
public class MenuServiceImpl implements MenuService {

    @Autowired
    private MenuDao menuDao;

    @Override
    public List<MenuEntity> menuList(int id) {
        return null;
    }

    @Override
    public List<MenuEntity> menusList(int pageSize, int start, String menuId) {
        return menuDao.menusList(pageSize, start, menuId);
    }
    @Override
    public Integer menusSize(int pageSize, int start, String menuId) {
        return menuDao.menusSize(pageSize, start, menuId);
    }

    @Override
    public List<MenuEntity> menusByParentId(int parentId) {
        return menuDao.menusByParentId(parentId);
    }
}
