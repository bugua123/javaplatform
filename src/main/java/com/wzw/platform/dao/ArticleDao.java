package com.wzw.platform.dao;

import com.wzw.platform.model.entity.ArticleEntity;
import com.wzw.platform.model.response.ArticleDetailResponse;
import com.wzw.platform.model.response.ArticleResponse;
import com.wzw.platform.utils.PageWrapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface ArticleDao {

    void insertArticle(ArticleEntity articleEntity);

    List<ArticleResponse>  getArticleList(@Param("searchContent") String searchContent, @Param("pageWrapper")PageWrapper pageWrapper);
    Integer getArticleSize(@Param("searchContent") String searchContent);
    ArticleDetailResponse getArticleById(@Param("id") int id);
    void addClickRateById(@Param("number") int number,@Param("id") int id);
    void addCommentCountById(@Param("number") int number,@Param("id") Integer articleId );
    List<ArticleResponse> getArticlesListByUserId(@Param("userId") int userId,@Param("pageWarpper") PageWrapper pageWrapper);
    Integer getArticleSizeByUserId(@Param("UserId") int userId);
    List<ArticleResponse> getArticleListOnManagement(@Param("searchContent") String searchContent, @Param("dayStart") String dayStart, @Param("dayEnd") String dayEnd, @Param("del") int del, @Param("pageWrapper") PageWrapper pageWrapper);

    int getArticleSizeOnManagement(@Param("searchContent") String searchContent, @Param("dayStart") String dayStart, @Param("dayEnd") String dayEnd, @Param("del") int del);

    void updateArticlesDelByIds(@Param("groupId") List<String> groupId, @Param("del") int del);

    void updateArticlesTopByIds(@Param("groupId") List<String> groupId, @Param("top") int top);

    void updateArticlesDelByIdAndUserId(@Param("userId") int userId,@Param("articleId") int articleId);

    void updateArticle(ArticleEntity articleEntity);



}
