package com.wzw.platform.service.impl;

import com.wzw.platform.dao.UserDetailDao;
import com.wzw.platform.model.entity.UserDetailEntity;
import com.wzw.platform.service.UserDetailService;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDetailServiceImpl implements UserDetailService {
    @Autowired
    private UserDetailDao userDetailDao;
    @Override
    public void updatedDaily() {
        userDetailDao.updateArticleSign(0);
    }

    @Override
    public UserDetailEntity getEntityByUserid(int userid) {
       return  userDetailDao.getEntityByUserid(userid);
    }

    @Override
    public void updateArticleSign(int articleSign, int userid) {
        userDetailDao.updateUseridArticleSign(articleSign,userid );
    }

    @Override
    public void updateUserInfo(int userId, String info, String location, String skill) {
        userDetailDao.updateUserInfo(userId, info, location, skill);
    }
}
