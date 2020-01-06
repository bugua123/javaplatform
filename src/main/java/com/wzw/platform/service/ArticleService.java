package com.wzw.platform.service;

import com.wzw.platform.model.request.ArticleCreateRequest;
import com.wzw.platform.model.request.ArticleUpdateRequest;
import com.wzw.platform.model.response.ArticleDetailResponse;
import com.wzw.platform.utils.PageResult;
import com.wzw.platform.utils.PageWrapper;

import java.util.List;

public interface ArticleService {

    void createArticle(ArticleCreateRequest articleCreateRequest);
    PageResult getArticle(String searchContent, PageWrapper pageWrapper);
    ArticleDetailResponse getArticleById(int id);
    void  addCommentCountById(Integer articleid);

    PageResult getArticlesByUserId(int userId,PageWrapper pageWrapper);

    PageResult getArticleOnManagement(String searchContent,String dateTimestamp,int del,PageWrapper pageWrapper);

    void updateArticlesDelByIds(List<String> groupId,int del);
    void updateArticlesTopByIds(List<String> groupId,int top);
    void  updateArticlesDelById(int articleId);
    void updateArticle(ArticleUpdateRequest articleUpdateRequest);
}
