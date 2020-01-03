package com.wzw.platform.controller.admin;

import com.wzw.platform.model.entity.MenuEntity;
import com.wzw.platform.service.MenuService;
import com.wzw.platform.utils.PageResult;
import com.wzw.platform.utils.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
@RestController
public class MenuController {
    private Logger log = LoggerFactory.getLogger(MenuController.class);

    @Autowired
    private MenuService menuService;
    /**
     * 获取menus表数据
     *
     * @param pageSize
     * @param page
     * @return
     */
//    @InterestLog
    @GetMapping("/menus")
    public ResponseWrapper<PageResult> menusList(int pageSize, int page, String menuId) {
        PageResult<MenuEntity> pageResult = new PageResult<>();
        pageResult.setData(menuService.menusList(pageSize, page * pageSize, menuId));
        pageResult.setTotalCount(menuService.menusSize(pageSize, page * pageSize, menuId));
        log.debug("The method is ending");
        return new ResponseWrapper<>(pageResult);
    }

}
