package com.liuhao.pojo;

import java.io.Serializable;

/**
 * 
 * @author 刘浩
 * @Title: ArticleVote.java 
 * @Package com.liuhao.pojo 
 * @Description: 投票表
 * @date 2019年12月10日 下午6:28:59
 */
public class ArticleVote implements Serializable{

	private Integer id;
	private Integer article_id;
	private Integer user_id;
	private String option;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getArticle_id() {
		return article_id;
	}
	public void setArticle_id(Integer article_id) {
		this.article_id = article_id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getOption() {
		return option;
	}
	public void setOption(String option) {
		this.option = option;
	}
	public ArticleVote() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "ArticleVote [id=" + id + ", article_id=" + article_id + ", user_id=" + user_id + ", option=" + option
				+ "]";
	}
	public ArticleVote(Integer id, Integer article_id, Integer user_id, String option) {
		super();
		this.id = id;
		this.article_id = article_id;
		this.user_id = user_id;
		this.option = option;
	}
	
	

}
