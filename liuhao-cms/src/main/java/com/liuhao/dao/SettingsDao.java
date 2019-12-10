package com.liuhao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.pojo.Settings;

public interface SettingsDao {
    /**
     * 
     * @Title: selectSettings 
     * @Description: 列表查询、条件查询
     * @param @param Settings
     * @param @return    设定文件 
     * @return List<Settings>    返回类型 
     * @throws
     */
	List<Settings> selectSettings(@Param("settings")Settings settings);
	/**
	 * 
	 * @Title: selectById 
	 * @Description: 根据id值查询Settings表 
	 * @param @param id
	 * @param @return    设定文件 
	 * @return Settings    返回类型 
	 * @throws
	 */
	Settings selectById(@Param("id") Integer id);
	/**
	 * 
	 * @Title: count 
	 * @Description: 查询数据条数
	 * @param @param Settings
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int count(@Param("settings") Settings settings);
	/**
	 * 
	 * @Title: insert 
	 * @Description: 添加Settings表
	 * @param @param Settings
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	
	int insert (@Param("settings") Settings settings);
	/**
	 * 
	 * @Title: update 
	 * @Description: 根据条件修改Settings表的数据 
	 * @param @param Settings
	 * @param @return    设定文件 
	 * @return int    返回类型 
	 * @throws
	 */
	int update(@Param("settings") Settings settings);
	/**
	 * 
	 * @Title: deleteById 
	 * @Description: 根据id删除Settings表的数据
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
