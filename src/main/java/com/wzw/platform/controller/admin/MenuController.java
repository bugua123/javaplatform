package com.wzw.platform.controller.admin;

import com.wzw.platform.model.entity.MenuEntity;
import com.wzw.platform.service.MenuService;
import com.wzw.platform.utils.PageResult;
import com.wzw.platform.utils.ResponseWrapper;
//import com.wzw.platform.utils.SecurityAuthenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.xml.ws.RequestWrapper;
import java.util.List;

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
     * http://localhost:8443/menus?pageSize=1&page=1
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
    /**
     * 通过parentId得到menus列表
     *
     * @param parentId
     * @return
     * http://localhost:8443//menus/parentId?parentId=0
     */
    @GetMapping("/menus/parentId")
    public ResponseWrapper<List<MenuEntity>> menusByParentId(int parentId) {
        return new ResponseWrapper<>(menuService.menusByParentId(parentId));
    }

    /***
     * 添加菜单
     * http://localhost:8443/menus/menu
     * {"name":"系统管理ttest","url":" ","parentId":0,"sort":1,"remark":null,"icon":"md-settings","children":null}
     * @param menuEntity
     * @return
     */
    @PostMapping("/menus/menu")
    public ResponseWrapper<MenuEntity> insertMenu(@RequestBody MenuEntity menuEntity) {
        menuService.insertMenu(menuEntity);
        log.debug("The method is ending");
        return new ResponseWrapper<>(menuEntity);
    }

    /***
     * 删除菜单信息
     * http://localhost:8443/menus
     * ["17","2000"]
     * @param groupId
     * @return
     */
    @DeleteMapping("/menus")
    public ResponseWrapper<List<String>> deleteMenus(@RequestBody List<String> groupId){
        menuService.deleteMenus(groupId);
        return  new ResponseWrapper<>(groupId);
    }

    /**
     * 修改菜单信息
     *http://localhost:8443/menus/18
     * {"name":"1111","url":" ","parentId":0,"sort":1,"remark":null,"icon":"md-settings","children":null}
     * @param menuEntity
     * @param id
     * @return
     */
    @PutMapping("/menus/{id}")
    public ResponseWrapper<MenuEntity> updateMenu(@RequestBody MenuEntity menuEntity, @PathVariable int id) {
        if (menuEntity.getId() == id) {
            menuService.updateMenu(menuEntity);
        }
        log.debug("The method is ending");
        return new ResponseWrapper<>(menuEntity);
    }
    /**
     * 获取该用户的菜单权限
     *
     * @return
     */
    @GetMapping("/manage/menu")
    public ResponseWrapper<List<MenuEntity>> menuList() {
//        List<MenuEntity> menuList = menuService.menuList(SecurityAuthenUtil.getId());
        List<MenuEntity> menuList = menuService.menuList(1);

        return new ResponseWrapper<>(menuList);
    }
    /**
     * 获取二级菜单
     *
     * @return
     */
    @GetMapping("/menus/submenus")
    public ResponseWrapper<List<MenuEntity>> getSubmenus() {

        return new ResponseWrapper<>(menuService.getSubmenus());
    }
}
