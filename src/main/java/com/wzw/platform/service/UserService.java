package com.wzw.platform.service;

import com.wzw.platform.model.entity.UserEntity;
import com.wzw.platform.model.request.UserInfoRequest;
import com.wzw.platform.model.response.UserInfoResponse;

import java.util.List;

public interface UserService {

    void insert(UserEntity userEntity);

    void del(UserEntity userEntity);

    /**
     * 通过登录名获取用户信息
     * @param loginName
     * @return
     */
    UserEntity getUserEntityByLoginName(String loginName);

    /**
     * 获取user 列表
     * @param name
     * @param pageSize
     * @param start
     * @return
     */
    List<UserEntity> usersList(String name,int pageSize,int start);

    /**
     * 获取用户总量
     * @param name
     * @param pageSize
     * @param start
     * @return
     */
    Integer userSize(String name,int pageSize,int start);

    /**
     * 新建用户
     * @param userEntity
     */
    void insertUser(UserEntity userEntity);

    /**
     * 更新用户信息
     * @param userEntity
     */
    void updateUser(UserEntity userEntity);

    void deleteUsers(List<String> groupId);

    void updateUsertype(UserEntity userEntity);

    UserEntity getEntityById(int userid);

    UserInfoResponse getUserInfoById(int userId);

    void updateUserInfoByUserId(int userId, UserInfoRequest userInfoRequest);

    void updateUserHeadImageToLocation();

    void updateUserHeadImg(int userId, String headImg);

    void updateUserUrl(int id);
}
