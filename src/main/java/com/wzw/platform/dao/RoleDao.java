package com.wzw.platform.dao;

import com.wzw.platform.model.entity.RoleEntity;
import org.apache.ibatis.annotations.Param;

import java.util.ArrayList;
import java.util.List;

public interface RoleDao {

    ArrayList<RoleEntity> rolesList(@Param("pageSize") int pageSize,@Param("start") int start);

    Integer rolesSize(@Param("pageSize") int pageSize,@Param("start") int start);

    void insertRole(@Param("roleEntity") RoleEntity roleEntity);

    void updateRole(@Param("roleEntity") RoleEntity roleEntity);

    void deleteRoles(@Param("groupId") List<String> grooupId);

    List<String> getModulesById(@Param("id") int id);

    List<RoleEntity> allRoles();

    List<String> getRolesByUserId(int id);
}
