package com.liuhao.pojo;
/**
 * 
 * @author 刘浩
 * @Title: VoteContent.java 
 * @Package com.liuhao.pojo 
 * @Description: 投票内容表 
 * @date 2019年12月10日 下午6:56:21
 */
public class VoteContent {

	private Integer id;
	private String content;
	private String title;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public VoteContent() {
		super();
		// TODO Auto-generated constructor stub
	}
	public VoteContent(Integer id, String content, String title) {
		super();
		this.id = id;
		this.content = content;
		this.title = title;
	}
	@Override
	public String toString() {
		return "VoteContent [id=" + id + ", content=" + content + ", title=" + title + "]";
	}
	
	

}
