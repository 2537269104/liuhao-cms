package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.Channel;

public interface ChannelDao {
    /**
     * 
     * @Title: selectChannel 
     * @Description: 列表查询、条件查询
     * @param @param Channel
     * @param @return    设定文件 
     * @return List<Channel>    返回类型 
     * @throws
     */
	List<Channel> selectChannel(@Param("channel")Channel channel);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询Channel表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Channel    返回类型 
	 * @throws
	 */
	Channel selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param Channel
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("channel") Channel channel);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加Channel表
	 * @param @param Channel
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("channel") Channel channel);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改Channel表的数据 
	 * @param @param Channel
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("channel") Channel channel);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除Channel表的数据
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
	
	List<Channel> select(Object object);
}
