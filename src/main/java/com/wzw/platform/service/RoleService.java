package com.wzw.platform.service;

import com.wzw.platform.model.entity.RoleEntity;

import java.util.List;

public interface RoleService {

    List<RoleEntity> rolesList(int pageSize,int start);

    Integer rolesSize(int pageSize,int start);

    void insertRole(RoleEntity roleEntity);

    void updateRole(RoleEntity roleEntity);
    void deleteRoles(List<String> groupId);

    List<RoleEntity> allRoles();
}
