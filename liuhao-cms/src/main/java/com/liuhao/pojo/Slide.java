package com.liuhao.pojo;
/**
 * 
 * @author 刘浩
 * @Title: Slide.java 
 * @Package com.liuhao.pojo 
 * @Description: 轮播图表 
 * @date 2019年12月10日 下午6:42:19
 */
public class Slide {

	private Integer id;
	private String title;
	private String picture;
	private String url;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getPicture() {
		return picture;
	}
	public void setPicture(String picture) {
		this.picture = picture;
	}
	public String getUrl() {
		return url;
	}
	public void setUrl(String url) {
		this.url = url;
	}
	public Slide(Integer id, String title, String picture, String url) {
		super();
		this.id = id;
		this.title = title;
		this.picture = picture;
		this.url = url;
	}
	@Override
	public String toString() {
		return "Slide [id=" + id + ", title=" + title + ", picture=" + picture + ", url=" + url + "]";
	}
	public Slide() {
		super();
		// TODO Auto-generated constructor stub
	}

}
