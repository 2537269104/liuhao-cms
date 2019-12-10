package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.VoteContent;

public interface VoteContentDao {
    /**
     * 
     * @Title: selectVoteContent 
     * @Description: 列表查询、条件查询
     * @param @param VoteContent
     * @param @return    设定文件 
     * @return List<VoteContent>    返回类型 
     * @throws
     */
	List<VoteContent> selectVoteContent(@Param("voteContent")VoteContent voteContent);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询VoteContent表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return VoteContent    返回类型 
	 * @throws
	 */
	VoteContent selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param VoteContent
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("voteContent") VoteContent voteContent);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加VoteContent表
	 * @param @param VoteContent
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("voteContent") VoteContent voteContent);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改VoteContent表的数据 
	 * @param @param VoteContent
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("voteContent") VoteContent voteContent);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除VoteContent表的数据
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
