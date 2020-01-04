package com.wzw.platform.service;

import com.wzw.platform.model.entity.UserDetailEntity;

public interface UserDetailService {

    void updatedDaily();

    UserDetailEntity getEntityByUserid(int userid);

    void updateArticleSign(int articleSign, int userid);

    void updateUserInfo(int userId, String info, String location, String skill);
}
