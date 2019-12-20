package com.liuhao.cms.service;

import com.github.pagehelper.PageInfo;
import com.liuhao.cms.pojo.Links;

public interface LinksService {
    /**
     * 
     * @Title: getPageInfo 
     * @Description: 链接表分页+模糊查询 
     * @param @param links
     * @param @param pageNum
     * @param @return    设定文件 
     * @return PageInfo<Links>    返回类型 
     * @throws
     */
	PageInfo<Links> getPageInfo(Links links, Integer pageNum);

}
