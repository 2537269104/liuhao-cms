package com.liuhao.cms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.liuhao.cms.dao.LinksDao;
import com.liuhao.cms.pojo.Links;
import com.liuhao.cms.service.LinksService;
@Service
public class LinksServiceImpl implements LinksService {

	@Autowired
	private LinksDao linksDao;

	@Override
	public PageInfo<Links> getPageInfo(Links links, Integer pageNum) {
		PageHelper.startPage(pageNum, 3);
		
		List<Links> linksList = linksDao.select(links);
		
		return new PageInfo<>(linksList);
	}
}
