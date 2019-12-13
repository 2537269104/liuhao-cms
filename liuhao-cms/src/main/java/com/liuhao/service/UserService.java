package com.liuhao.service;

import com.github.pagehelper.PageInfo;
import com.liuhao.pojo.User;

public interface UserService {
   
	PageInfo<User> getPageInfo(User user, Integer pageNum, Integer pageSize);
	
	public boolean locked(Integer userId);
	
	public boolean unLocked(Integer userId);
}
