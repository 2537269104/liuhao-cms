package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.Tag;

public interface TagDao {
    /**
     * 
     * @Title: selectTag 
     * @Description: 列表查询、条件查询
     * @param @param Tag
     * @param @return    设定文件 
     * @return List<Tag>    返回类型 
     * @throws
     */
	List<Tag> selectTag(@Param("tag")Tag Tag);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询Tag表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Tag    返回类型 
	 * @throws
	 */
	Tag selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param Tag
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("tag") Tag tag);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加Tag表
	 * @param @param Tag
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("tag") Tag tag);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改Tag表的数据 
	 * @param @param Tag
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("tag") Tag tag);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除Tag表的数据
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
