package com.liuhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.dao.ArticleDao;
import com.liuhao.pojo.Article;
import com.liuhao.pojo.Channel;
import com.liuhao.pojo.Condition;
import com.liuhao.pojo.User;
import com.liuhao.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	@Override
	public PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize) {
		
			
			PageInfo<User> pageInfo = null;
			PageHelper.startPage(pageNum, pageSize);
			
			List<Article> userList = articleDao.selectArticle(article);
			
			return new PageInfo<>(userList);
		
	}
	
}
