package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.Article;
import com.liuhao.pojo.ArticleVote;
import com.liuhao.pojo.User;

public interface ArticleVoteDao {
    /**
     * 
     * @Title: selectUser 
     * @Description: 列表查询、条件查询
     * @param @param user
     * @param @return    设定文件 
     * @return List<User>    返回类型 
     * @throws
     */
	List<ArticleVote> selectArticleVote(@Param("articleVote")ArticleVote articleVote);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询User表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return User    返回类型 
	 * @throws
	 */
	ArticleVote selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param article
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("articleVote") ArticleVote articleVote);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加article表
	 * @param @param article
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("articleVote") ArticleVote articleVote);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改article表的数据 
	 * @param @param user
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("articleVote") ArticleVote articleVote);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除article表的数据
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
