package com.liuhao.pojo;

import java.io.Serializable;

/**
 * 
 * @author 刘浩
 * @Title: Category.java 
 * @Package com.liuhao.controller 
 * @Description: 分类表    
 * @date 2019年12月10日 下午6:31:42
 */
public class Category  implements Serializable{

	private Integer id;
	private Integer name;
	private Integer channel_id;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getName() {
		return name;
	}
	public void setName(Integer name) {
		this.name = name;
	}
	public Integer getChannel_id() {
		return channel_id;
	}
	public void setChannel_id(Integer channel_id) {
		this.channel_id = channel_id;
	}
	public Category() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Category [id=" + id + ", name=" + name + ", channel_id=" + channel_id + "]";
	}
	public Category(Integer id, Integer name, Integer channel_id) {
		super();
		this.id = id;
		this.name = name;
		this.channel_id = channel_id;
	}

	
}
