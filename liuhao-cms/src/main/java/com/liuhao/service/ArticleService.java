package com.liuhao.service;

import com.github.pagehelper.PageInfo;
import com.liuhao.pojo.Article;

public interface ArticleService {



	PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize);

	boolean addHot(Integer id);


	boolean checkArticle(Integer id, Integer status);

	Article getById(Integer id);

	Object save(Article article);

	Object getCateListByChannelId(Integer channelId);


}
