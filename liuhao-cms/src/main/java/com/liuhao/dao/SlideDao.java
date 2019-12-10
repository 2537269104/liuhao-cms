package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.Slide;

public interface SlideDao {
    /**
     * 
     * @Title: selectSlide 
     * @Description: 列表查询、条件查询
     * @param @param Slide
     * @param @return    设定文件 
     * @return List<Slide>    返回类型 
     * @throws
     */
	List<Slide> selectSlide(@Param("slide")Slide slide);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询Slide表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Slide    返回类型 
	 * @throws
	 */
	Slide selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param Slide
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("slide") Slide slide);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加Slide表
	 * @param @param Slide
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("slide") Slide slide);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改Slide表的数据 
	 * @param @param Slide
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("slide") Slide slide);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除Slide表的数据
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
