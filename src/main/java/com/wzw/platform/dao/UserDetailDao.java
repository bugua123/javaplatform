package com.wzw.platform.dao;

import com.wzw.platform.model.entity.UserDetailEntity;
import org.apache.ibatis.annotations.Param;

public interface UserDetailDao {
    void insert(UserDetailEntity userDetailEntity);

    void updateArticleSign(@Param("articleSign") int articleSign);

    UserDetailEntity getEntityByUserid(@Param("userid") int userid);

    void updateUseridArticleSign(@Param("articleSign") int articleSign,@Param("userid") int userid);

    void updateUserInfo(@Param("userId") int userId,@Param("info") String info,@Param("location") String location,@Param("skill") String skill);

}
