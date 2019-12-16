package com.liuhao.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.dao.UserDao;
import com.liuhao.pojo.User;
import com.liuhao.service.UserService;
@Service
public class UserServiceImpl implements  UserService {

	@Autowired
	private UserDao userDao;
	 /**
     * 
     * @Title: getPageInfo 
     * @Description: 分页查询 列表查询
     * @param @param user
     * @param @param pageNum
     * @param @param pageSize
     * @param @return    设定文件 
     * @return PageInfo<User>    返回类型 
     * @throws
     */
	public PageInfo<User> getPageInfo(User user, Integer pageNum, Integer pageSize) {
		
		PageInfo<User> pageInfo = null;
		PageHelper.startPage(pageNum, pageSize);
		
		List<User> userList = userDao.selectUser(user);
		
		return new PageInfo<>(userList);
	}
	/**
	 * 
	 * @Title: locked 
	 * @Description: 禁用用户
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	public boolean locked(Integer userId) {
		
		return userDao.updateLocked(userId,1);
	}
     /**
      * 
      * @Title: unLocked 
      * @Description: 启用用户
      * @param @return    设定文件 
      * @return boolean    返回类型 
      * @throws
      */
	public boolean unLocked(Integer userId) {
		
	 return userDao.updateLocked(userId,0);
	}
	@Override
	public User getByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.selectByUsername(username);
	}
}
