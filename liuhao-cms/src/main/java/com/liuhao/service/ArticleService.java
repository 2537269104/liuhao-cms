package com.liuhao.service;

import java.util.List;

import com.github.pagehelper.PageInfo;
import com.liuhao.pojo.Article;
import com.liuhao.pojo.Channel;

public interface ArticleService {



	PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize);


}
