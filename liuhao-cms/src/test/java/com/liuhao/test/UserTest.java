package com.liuhao.test;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.liuhao.dao.UserDao;
import com.liuhao.pojo.User;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:spring-beans.xml")
public class UserTest {

	@Autowired
	private UserDao userDao;
	
	@Test
	public void select() {
		
		List<User> user = userDao.selectUser(null);
		System.out.println(user);
	}
}
