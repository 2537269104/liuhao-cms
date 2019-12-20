package com.liuhao.cms.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.liuhao.cms.pojo.Links;

public interface LinksDao {

	List<Links> select(@Param("links")Links links);

	
}
