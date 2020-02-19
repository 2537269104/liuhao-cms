package com.liuhao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuhao.cms.dao.CollectDao;
import com.liuhao.cms.pojo.Collect;
import com.liuhao.cms.util.StringUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class MyTest {
	
    @Autowired
    private CollectDao collectDao;
	@Test
	public void test01() {
		System.out.println(StringUtil.isHttpUrl("http://localhost/user/center"));
	}
	@Test
	public void delete() {
		
		 collectDao.deleteById(27);
	}
	
	@Test
	public void test03() {
		Collect collect = new Collect();
		collect.setUserId(153);
		List<Collect> listCollect = collectDao.selectByUserId(collect);
	    System.out.println(listCollect);
	
	}
}
