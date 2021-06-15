package com.douzone.container.user;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.douzone.container.config.user.AppConfig01;

//spring 내부에서 test
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(Classes.class= {AppConfig01.class}) --?
@ContextConfiguration(locations= {"/com/douzone/container/config/user/AppConfig01.class"})
public class XmlConfigTest {
	
	@Autowired
	private User user;
	
	@Test
	public void testUserNotNull() {
		
	}
}
