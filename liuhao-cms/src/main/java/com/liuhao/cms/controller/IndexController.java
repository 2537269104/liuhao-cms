package com.liuhao.cms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.github.pagehelper.PageInfo;
import com.liuhao.cms.pojo.Article;
import com.liuhao.cms.pojo.Category;
import com.liuhao.cms.pojo.Channel;
import com.liuhao.cms.pojo.Links;
import com.liuhao.cms.pojo.Slide;
import com.liuhao.cms.pojo.User;
import com.liuhao.cms.service.ArticleService;
import com.liuhao.cms.service.LinksService;
import com.liuhao.cms.service.SlideService;
import com.liuhao.cms.service.UserService;

@Controller
public class IndexController {
	
	@Autowired
	private ArticleService articleService;
	@Autowired
	private UserService userService;
	@Autowired
	private SlideService slideService;
	@Autowired
	private LinksService linksService;
	
	@RequestMapping(value="/")
	public String index(Model model) {
		return index(1, model);
	}
	
	@RequestMapping(value="/hot/{pageNum}.html")
	public String index(@PathVariable Integer pageNum,Model model) {
		//频道
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		//轮播图
		List<Slide> slideList = slideService.getAll();
		model.addAttribute("slideList", slideList);
		/** 最新文章**/
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		//热点文章
		if(pageNum==null) {
			pageNum=1;
		}
		//获取热点文章
		PageInfo<Article> pageInfo = articleService.getHotList(pageNum);
		model.addAttribute("pageInfo", pageInfo);
		//获取收藏链接
		List<Links> linksList = linksService.select();
		model.addAttribute("linksList", linksList);
		return "index";
	}
	
	/**
	 * 
	 * @Title: channel 
	 * @Description: 频道页     分类页     频道下的分类下的分页方法    
	 * @param @param channelId
	 * @param @param model
	 * @param @param cateId
	 * @param @param pageNo
	 * @param @return    设定文件 
	 * @return String    返回类型 
	 * @throws
	 */
	@RequestMapping("/{channelId}/{cateId}/{pageNo}.html")
	public String channel(@PathVariable Integer channelId,Model model,
			@PathVariable Integer cateId,@PathVariable Integer pageNo) {
		//频道
		List<Channel> channelList = articleService.getChannelList();
		model.addAttribute("channelList", channelList);
		//分类
		List<Category> cateList = articleService.getCateListByChannelId(channelId);
		model.addAttribute("cateList", cateList);
		//根据频道id和分类id查询文章
		PageInfo<Article> pageInfo =  articleService.getListByChannelIdAndCateId(channelId,cateId,pageNo);
		model.addAttribute("pageInfo", pageInfo);
		/** 最新文章**/
		List<Article> newArticleList = articleService.getNewList(6);
		model.addAttribute("newArticleList", newArticleList);
		
		return "index";
	}
	//文章详情页查询
	@RequestMapping("article/{id}.html")
	public String articleDetail(@PathVariable Integer id,Model model) {
		//查询文章
		Article article = articleService.getById(id);
		model.addAttribute("article", article);
		//查询用户
		User user =userService.getById(article.getUserId());
		
		model.addAttribute("user",user);
		//查询相关文章
		List<Article> articleList = articleService.getListByChannelId(article.getChannelId(),id,10);
		model.addAttribute("articleList", articleList);
		return "article/detail";
	}
	
}