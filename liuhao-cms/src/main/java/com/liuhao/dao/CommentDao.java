package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.Comment;

public interface CommentDao {
    /**
     * 
     * @Title: selectComment 
     * @Description: 列表查询、条件查询
     * @param @param Comment
     * @param @return    设定文件 
     * @return List<Comment>    返回类型 
     * @throws
     */
	List<Comment> selectComment(@Param("comment")Comment comment);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询Comment表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Comment    返回类型 
	 * @throws
	 */
	Comment selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param Comment
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("comment") Comment Comment);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加Comment表
	 * @param @param Comment
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("comment") Comment comment);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改Comment表的数据 
	 * @param @param Comment
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("comment") Comment comment);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除Comment表的数据
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
}
