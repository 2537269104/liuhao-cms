package com.liuhao.pojo;
/**
 * 
 * @author 刘浩
 * @Title: Tag.java 
 * @Package com.liuhao.pojo 
 * @Description: 标签表  
 * @date 2019年12月10日 下午6:54:35
 */
public class Tag {
	private Integer id;
	private String tagname;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getTagname() {
		return tagname;
	}
	public void setTagname(String tagname) {
		this.tagname = tagname;
	}
	public Tag() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Tag [id=" + id + ", tagname=" + tagname + "]";
	}
	public Tag(Integer id, String tagname) {
		super();
		this.id = id;
		this.tagname = tagname;
	}

	
}
