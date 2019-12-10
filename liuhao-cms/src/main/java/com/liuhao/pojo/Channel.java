package com.liuhao.pojo;
/**
 * 
 * @author 刘浩
 * @Title: Channel.java 
 * @Package com.liuhao.controller 
 * @Description: 频道类
 * @date 2019年12月10日 下午6:33:03
 */
public class Channel {

	private Integer id;
	private String name;
	private String description;
	private String icon;
	private Integer sorted;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getIcon() {
		return icon;
	}
	public void setIcon(String icon) {
		this.icon = icon;
	}
	public Integer getSorted() {
		return sorted;
	}
	public void setSorted(Integer sorted) {
		this.sorted = sorted;
	}
	public Channel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Channel(Integer id, String name, String description, String icon, Integer sorted) {
		super();
		this.id = id;
		this.name = name;
		this.description = description;
		this.icon = icon;
		this.sorted = sorted;
	}
	@Override
	public String toString() {
		return "Channel [id=" + id + ", name=" + name + ", description=" + description + ", icon=" + icon + ", sorted="
				+ sorted + "]";
	}

	
}
