package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.User;

public interface UserDao {
    /**
     * 
     * @Title: selectUser 
     * @Description: 列表查询、条件查询
     * @param @param user
     * @param @return    设定文件 
     * @return List<User>    返回类型 
     * @throws
     */
	List<User> selectUser(@Param("user")User user);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询User表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	User selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param user
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("user") User user);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加user表
	 * @param @param user
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("user") User user);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改user表的数据 
	 * @param @param user
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("user") User user);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除user表的数据
	 * @param @param id
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int deleteById(@Param("id")  Integer id);
	/**
	 * 
	 * @Title: deleteByIds 
	 * @Description: 根据ids字符串删除数据 
	 * @param @param ids
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int deleteByIds(@Param("ids") String ids);
	
	/**
	 * 
	 * @Title: updateLocked 
	 * @Description: 根据user的id值 修改 user的状态
	 * @param @param userId
	 * @param @param i
	 * @param @return    设定文件 
	 * @return boolean    返回类型 
	 * @throws
	 */
	boolean updateLocked(@Param("userId")Integer userId, @Param("locked")int locked);
}
