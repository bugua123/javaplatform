package com.wzw.platform.controller.admin;


import com.wzw.platform.model.entity.RoleEntity;
import com.wzw.platform.service.RoleService;
import com.wzw.platform.utils.PageResult;
import com.wzw.platform.utils.ResponseWrapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class RoleController {
    private Logger log = LoggerFactory.getLogger(RoleController.class);
    @Autowired
    private RoleService roleService;

    @GetMapping("/roles")
    public ResponseWrapper<PageResult> rolesList(String loginName,int pageSize,int page){
        PageResult<RoleEntity> pageResult=new PageResult<>();
        pageResult.setData(roleService.rolesList(pageSize, page * pageSize));
        pageResult.setTotalCount(roleService.rolesSize(pageSize, page * pageSize));
        log.debug("The method is ending");
        return new ResponseWrapper<>(pageResult);
    }

    @PostMapping("/roles/role")
    public ResponseWrapper<RoleEntity> insertRole(@RequestBody RoleEntity roleEntity){
        roleService.insertRole(roleEntity);
        return new ResponseWrapper<>(roleEntity);
    }

    @PutMapping("/roles/{id}")
    public ResponseWrapper<RoleEntity> updateRole(@RequestBody RoleEntity roleEntity, @PathVariable int id){
        if(roleEntity.getId()==id){
            roleService.updateRole(roleEntity);
        }
        return new ResponseWrapper<>(roleEntity);
    }

    @DeleteMapping("/roles")
    public ResponseWrapper<List<String>> deleteRoles(@RequestBody List<String> groupId){
        roleService.deleteRoles(groupId);
        return new ResponseWrapper<>(groupId);
    }

    @GetMapping("roles/all")
    public ResponseWrapper<List<RoleEntity>> allRoles(){
        return new ResponseWrapper<>(roleService.allRoles());
    }
}
