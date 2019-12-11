package com.liuhao.pojo;

import java.io.Serializable;

/**
 * 
 * @author 刘浩
 * @Title: ArticleTag.java 
 * @Package com.liuhao.pojo 
 * @Description: 文章标签关联表
 * @date 2019年12月10日 下午6:27:07
 */
public class ArticleTag implements Serializable {
 
	private Integer aid;
	private Integer tid;
	public Integer getAid() {
		return aid;
	}
	public void setAid(Integer aid) {
		this.aid = aid;
	}
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public ArticleTag() {
		super();
		// TODO Auto-generated constructor stub
	}
	public ArticleTag(Integer aid, Integer tid) {
		super();
		this.aid = aid;
		this.tid = tid;
	}
	@Override
	public String toString() {
		return "ArticleTag [aid=" + aid + ", tid=" + tid + "]";
	}
	

}
