package com.liuhao.cms.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.cms.dao.ArticleDao;
import com.liuhao.cms.dao.CategoryDao;
import com.liuhao.cms.dao.ChannelDao;
import com.liuhao.cms.pojo.Article;
import com.liuhao.cms.pojo.Category;
import com.liuhao.cms.pojo.Channel;
import com.liuhao.cms.service.ArticleService;
@Service
public class ArticleServiceImpl implements ArticleService {
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private ChannelDao channelDao;
	@Autowired
	private CategoryDao categoryDao;
	
	
	@Override
	public PageInfo<Article> getPageInfo(Article article, int pageNum, int pageSize) {
		PageHelper.startPage(pageNum, pageSize);
		List<Article> articleList = articleDao.select(article);
		return new PageInfo<>(articleList);
	}

	@Override
	public boolean updateStatus(Integer id, int status) {
		return articleDao.updateStatus(id, status)>0;
	}

	@Override
	public boolean addHot(Integer id) {
		return articleDao.addHot(id)>0;
	}

	@Override
	public List<Channel> getChannelList() {
		return channelDao.select(null);
	}

	@Override
	public Article getById(Integer id) {
		return articleDao.selectById(id);
	}
     //保存文章中的内容
	@Override
	public boolean save(Article article) {
		//做验证  当新添加文章时  删除  发布时间  等状态设为默认值
		if(article.getId()==null) {
			article.setDeleted(0);
			article.setCreated(new Date());
			article.setUpdated(new Date());
			article.setCommentcnt(0);
			article.setHits(0);
			article.setHot(0);
			//添加文章
			articleDao.insert(article);
		}else {
			//如果有值 则对文章进行修改 且修改  修改时间
			article.setUpdated(new Date());
			articleDao.update(article);
		}
		return true;
	}
     //根据频道id查询样式表集合
	@Override
	public List<Category> getCateListByChannelId(Integer channelId) {
		return categoryDao.selectListByChannelId(channelId);
	}

	@Override
	public boolean delByIds(String ids) {
		
		return articleDao.deleteByIds(ids)>0;
	}

	@Override
	public boolean isAllCheck(String ids) {
        
		List<Article> articleList = articleDao.selectByIds(ids);
		for (Article article:articleList) {
			if(article.getStatus()==1) {
				return false;
			}
		}
		return true;
	}

	@Override
	public List<Article> getListByChannelId(Integer channelId, Integer aritcleId, int num) {
		
		return articleDao.selectListByChannelId(channelId,aritcleId,num);
	}

	@Override
	public PageInfo<Article> getHotList(int pageNum) {

		PageHelper.startPage(pageNum, 1);
		List<Article> articleList = articleDao.selectByHot();
		return new PageInfo<>(articleList);
	}

	@Override
	public PageInfo<Article> getListByChannelIdAndCateId(Integer channelId, Integer cateId, Integer pageNo) {
		PageHelper.startPage(pageNo, 1);
		List<Article> articleList = articleDao.selectListByChannelIdAndCateId(channelId,cateId);
		
		return new PageInfo<>(articleList);
	}

	@Override
	public List<Article> getNewList(int i) {
		// TODO Auto-generated method stub
		return articleDao.selectNewList(i);
	}

}
