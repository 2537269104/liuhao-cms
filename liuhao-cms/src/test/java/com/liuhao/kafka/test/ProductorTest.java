package com.liuhao.kafka.test;

import java.io.File;
import java.util.Date;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.IndexQuery;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.alibaba.fastjson.JSON;
import com.liuhao.cms.dao.ArticleRepository;
import com.liuhao.cms.dao.CategoryDao;
import com.liuhao.cms.dao.ChannelDao;
import com.liuhao.cms.pojo.Article;
import com.liuhao.cms.pojo.Category;
import com.liuhao.cms.service.impl.RedisArticleServiceImpl;
import com.liuhao.util.DateUtil;
import com.liuhao.util.JSoup;
import com.liuhao.util.RandomUtil;
import com.liuhao.util.StreamUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-beans.xml")
public class ProductorTest {

	@Autowired
	private CategoryDao categoryDao;
	@Autowired
    private KafkaTemplate<String, String> kafkaTemplate;	
	@Autowired
	private ArticleRepository articleRepository;
	@Autowired
	private ElasticsearchTemplate elasticsearchTemplate;
	@Autowired
	private RedisArticleServiceImpl articleServiceImpl;
	
	@Test
	public void test() {
	  //获取读到的文件
	  //List<String> readList = StreamUtil.readTextFileByLine2(new File("D:\\1709DJsoup"));
	   File file = new File("D:\\1709DJsoup");
	   String[] list = file.list();
	   for (String str : list) {
		//将文件名作为Article对象的title属性值。文本内容作为Article对象的content属性值
		Article article = new Article();
		int i = str.lastIndexOf(".");
	    //标题
		String title = str.substring(0,i);
	    article.setTitle(title);
	    //每个文件的路径
	    String textpath="D:\\1709DJsoup\\"+str;
	    String content = StreamUtil.readTextFile(new File(textpath));
	    article.setContent(content);
	    //在文本内容中截取前140个字作为摘要
	    String zhaiYao = content.substring(0,140);
	    article.setZhaiYao(zhaiYao);
	  //“点击量”和“是否热门”、“频道”字段要使用随机值。
	    int j = RandomUtil.random(0, 10000);
	    article.setHits(j);
	    int m = RandomUtil.random(0, 10000);
	    article.setHot(m);
	    //一共有9个频道
	    int n = RandomUtil.random(1, 9);
	    article.setChannelId(n);
	    //根据频道id查分类id
	    List<Category> cateList = categoryDao.selectListByChannelId(n);
	    Category category = cateList.get(0);
	    article.setCategoryId(category.getId());
	    //文章发布日期从2019年1月1日模拟到今天
	    Date date = DateUtil.randomDate("2019-01-01", "2020-02-13");
	    article.setCreated(date);
	    article.setPicture("");
	    article.setDeleted(0);
	    //通过kafka发送给消费者 
	    //String jsonString = JSON.toJSONString(article);
	    //kafkaTemplate.sendDefault("add",jsonString);
	    //通过redisServiceImpl的save方法保存到redis中
	    article.setUserId(183);
	    articleServiceImpl.save(article);
	   }
	    System.out.println("111111111111111111111111111111111111111111111");
	}
}
