package com.liuhao.controller.admin;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageInfo;
import com.liuhao.dao.ArticleDao;
import com.liuhao.pojo.Article;
import com.liuhao.pojo.Settings;
import com.liuhao.pojo.User;
import com.liuhao.service.SettingsService;
import com.liuhao.service.UserService;
import com.liuhao.util.Md5Util;

@Controller
@RequestMapping("/admin/")
public class AdminController {

	
	@Autowired
	private UserService userService;
	@Autowired
	private ArticleDao articleDao;
	@Autowired
	private SettingsService settingsService;
	
	
	@RequestMapping("/")
	public String login() {
		
		return "admin/login";
	} 
   
	
	
	
	
	@RequestMapping("/home")
	public String home() {
		return "admin/home";
	}
	
	@RequestMapping("/user")
	public String user(User user,Model m,
			@RequestParam(value = "pageNum" ,defaultValue = "1")Integer pageNum,@RequestParam(value = "pageSize" ,defaultValue = "3")Integer pageSize) {
		
		PageInfo<User> pageInfo = userService.getPageInfo(user,pageNum,pageSize);
		
		m.addAttribute("pageInfo", pageInfo);
		return "admin/user";
	}
	
	@RequestMapping("/welcome")
	public String welcome() {
		return "admin/welcome";
	}
	
	@RequestMapping("/articleManager")
	public String articleManager() {
		
		return "admin/articleManager";
	} 
	
	@RequestMapping("/settings")
	public String settings(Model m) {
		
       Settings settings = settingsService.getSettings();
		m.addAttribute("settings", settings);
		return "admin/settings";
	} 
		
	@RequestMapping("/addArticle")
	public String addArticle(Model model) {
		Article article = articleDao.selectById(1);
		Md5Util.string2MD5("abc");
		model.addAttribute("article", article);
		return "admin/addArticle";
	} 
	@ResponseBody
	@RequestMapping("/userLocked")
	public boolean userLocked(@RequestParam("userId")Integer userId) {
		
		return userService.locked(userId);
	}
	@ResponseBody
	@RequestMapping("/userUnLocked")
	public boolean userUnLocked(@RequestParam("userId")Integer userId) {
		
		return userService.unLocked(userId);
	}
	
}
