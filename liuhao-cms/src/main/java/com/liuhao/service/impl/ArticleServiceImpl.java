package com.liuhao.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.dao.ArticleDao;
import com.liuhao.dao.CategoryDao;
import com.liuhao.dao.ChannelDao;
import com.liuhao.pojo.Article;
import com.liuhao.pojo.Channel;
import com.liuhao.pojo.Condition;
import com.liuhao.pojo.User;
import com.liuhao.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService{

	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChannelDao channelDao;
	@Autowired
	private CategoryDao categoryDao;
	@Override
	public PageInfo<Article> getPageInfo(Article article, Integer pageNum, Integer pageSize) {
		
			
			PageInfo<User> pageInfo = null;
			PageHelper.startPage(pageNum, pageSize);
			
			List<Article> userList = articleDao.selectArticle(article);
			
			return new PageInfo<>(userList);
		
	}
	@Override
	public boolean addHot(Integer id) {
		// TODO Auto-generated method stub
		return articleDao.updateHot(id)>0;
	}
	@Override
	public boolean checkArticle(Integer id, Integer status) {
		
		
		return articleDao.updateStatus(id,status);
	}
	@Override
	public Article getById(Integer id) {
		
		return articleDao.selectById(id);
	}
	@Override
	public Object save(Article article) {
		if(article.getId()==null) {
			article.setDeleted(0);
			article.setCreated(new Date());
			article.setUpdated(new Date());
			article.setCommentCnt("0");
			article.setHits(0);
			article.setHot(0);
			articleDao.insert(article);
		}else {
			article.setUpdated(new Date());
			articleDao.update(article);
		}
		return false;
	}
	@Override
	public Object getCateListByChannelId(Integer channelId) {
		
		return categoryDao.selectListByChannelId(channelId);
	}
	
}
