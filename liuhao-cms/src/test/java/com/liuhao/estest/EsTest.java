package com.liuhao.estest;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuhao.cms.dao.ArticleDao;
import com.liuhao.cms.dao.ArticleRepository;
import com.liuhao.cms.pojo.Article;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class EsTest {

	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ArticleDao articleDao;
	@Test
	public void test() {
		
		//查询所有文章
		List<Article> list = articleDao.select(new Article());
		articleRepository.saveAll(list);
		System.out.println("文章全部导入完毕！");
		
		
	}
}
