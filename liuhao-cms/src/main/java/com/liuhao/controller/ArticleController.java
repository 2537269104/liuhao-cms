package com.liuhao.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.common.CmsConstant;
import com.liuhao.common.JsonResult;
import com.liuhao.pojo.Article;
import com.liuhao.pojo.Channel;
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
	/**
	 * @Title: add   
	 * @Description: 发布文章   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping(value="add",method=RequestMethod.GET)
	public String add(Integer id,Model model) {
		if(id!=null) {
			Article article = articleService.getById(id);
			model.addAttribute("article", article);
		}
		List<Channel> channelList = channelService.selectChannel();
		model.addAttribute("channelList", channelList);
		return "article/add";
	}
	
	@RequestMapping(value="add",method=RequestMethod.POST)
	@ResponseBody
	public JsonResult add(Article article,Model model,HttpSession session) {
		User userInfo = (User)session.getAttribute(CmsConstant.UserSessionKey);
		if(userInfo==null) {
			return JsonResult.fail(CmsConstant.unLoginErrorCode, "未登录");
		}
		article.setUser_id(userInfo.getId());
		return JsonResult.sucess(articleService.save(article));
	}
	/**
	 * @Title: getCateList   
	 * @Description: 根据频道Id查询分类列表   
	 * @param: @param channelId
	 * @param: @param model
	 * @param: @param session
	 * @param: @return      
	 * @return: JsonResult      
	 * @throws
	 */
	@RequestMapping(value="getCateList",method=RequestMethod.GET)
	@ResponseBody
	public JsonResult getCateList(Integer channelId,Model model,HttpSession session) {
		return JsonResult.sucess(articleService.getCateListByChannelId(channelId));
	}
	/**
	 * @Title: update   
	 * @Description: 修改文章   
	 * @param: @return      
	 * @return: String      
	 * @throws
	 */
	@RequestMapping("update")
	public String update() {
		return "update";
	}
}
