package com.liuhao.cms.test;


import org.json.simple.JSONObject;

import com.liuhao.cms.pojo.Article;

public class MyTest {

	
	private void mian() {
		// TODO Auto-generated method stub
         String str= "{\"A\":\"湿垃圾\",\"B\":\"干垃圾\",\"C\":\"有害垃圾\",\"D\":\"可回收物\"}";
         
         Article article = new Article();
         
         JSONObject.escape(str);
	}
}
