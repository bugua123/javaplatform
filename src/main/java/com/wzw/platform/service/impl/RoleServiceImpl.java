package com.wzw.platform.service.impl;

import com.wzw.platform.model.entity.RoleEntity;
import com.wzw.platform.service.RoleService;
import org.springframework.stereotype.Service;

import java.util.List;


@Service(value = "roleServiceImpl")
public class RoleServiceImpl implements RoleService {
    @Override
    public List<RoleEntity> rolesList(int pageSize, int start) {
        return null;
    }

    @Override
    public Integer rolesSize(int pageSize, int start) {
        return null;
    }

    @Override
    public void insertRole(RoleEntity roleEntity) {

    }

    @Override
    public void updateRole(RoleEntity roleEntity) {

    }

    @Override
    public void deleteRoles(List<String> groupId) {

    }

    @Override
    public List<RoleEntity> allRoles() {
        return null;
    }
}
