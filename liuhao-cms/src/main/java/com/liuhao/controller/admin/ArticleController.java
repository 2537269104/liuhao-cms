package com.liuhao.controller.admin;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.pojo.Article;
import com.liuhao.pojo.Channel;
import com.liuhao.pojo.Condition;
import com.liuhao.pojo.User;
import com.liuhao.service.ArticleService;
import com.liuhao.service.ChannelService;

@Controller
@RequestMapping("/article/")
public class ArticleController {

	@Autowired
	private ArticleService articleService;
	@Autowired 
	private ChannelService channelService;
	
	@RequestMapping("/articleList")
	public String articleList(Article article,Model m,
			@RequestParam(value = "pageNum" ,defaultValue = "1")Integer pageNum,@RequestParam(value = "pageSize" ,defaultValue = "5")Integer pageSize) {
		
		PageInfo<Article> pageInfo = articleService.getPageInfo(article,pageNum,pageSize);
		List<Channel> channelList =channelService.selectChannel();
		m.addAttribute("pageInfo", pageInfo);
		m.addAttribute("channelList", channelList);
		return "admin/articleManager";
	}
	
	
	@ResponseBody
	@RequestMapping("/addHot")
	public boolean addHot(Article article) {
		
		return articleService.addHot(article.getId());
	}
	@ResponseBody
	@RequestMapping("/checkArticle")
	public boolean checkArticle(Article article) {
		
		return articleService.checkArticle(article.getId(),article.getStatus());
	}
}
