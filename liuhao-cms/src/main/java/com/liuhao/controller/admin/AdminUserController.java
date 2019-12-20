package com.liuhao.controller.admin;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.liuhao.common.CmsConstant;
import com.liuhao.common.CmsMd5Util;
import com.liuhao.common.JsonResult;
import com.liuhao.pojo.User;
import com.liuhao.service.UserService;
import com.liuhao.util.StringUtil;

@Controller
@RequestMapping("/admin/user/")
public class AdminUserController {

	
	@Autowired
	private UserService userService;
	
	 @ResponseBody
		@RequestMapping("/login")
		public Object toLogin(User user,HttpSession session) {
	    	//判断用户名和密码是否为空
		 if(StringUtil.isBlank(user.getUsername()) || StringUtil.isBlank(user.getPassword())) {
			 return JsonResult.fail(1000, "用户名和密码不能为空");
		 }
	    	 //查询用户
		 User userInfo = userService.getByUsername(user.getUsername());
	    if(!userInfo.isAdmin()) {
	    	return JsonResult.fail(1000, "权限不够");
	    }	
         //判断密码
	    String string2md5 = CmsMd5Util.string2MD5(user.getPassword());
	    System.out.println(string2md5+"               "+userInfo.getPassword());
	    if(string2md5.equals(userInfo.getPassword())) {
	    	 session.setAttribute(CmsConstant.UserAdminSessionKey, userInfo);
	    	 return JsonResult.sucess();
	    }
	 
	    return JsonResult.fail(500, "未知错误");
	 }
	 
	 @RequestMapping("logout")
		public Object logout(HttpServletResponse response,HttpSession session) {
			session.removeAttribute(CmsConstant.UserAdminSessionKey);
			return "redirect:/admin/";
		}
}
