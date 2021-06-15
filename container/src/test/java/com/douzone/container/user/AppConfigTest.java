package com.douzone.container.user;

import static org.junit.Assert.assertNotNull;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.config.user.AppConfig01;

public class AppConfigTest {
	
	// Java Config01
	// 직접 설정 자바 클래스 전달
	//  설정 클래스에 @Configuration X
	@Test
	public void testAppConfig01() {
		// AppConfig01에는 @Configuration X
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);
		
		User user = ac.getBean(User.class);
		assertNotNull(user);
	}
	
	// Java Config02
	// java config class가 있는 base package 전달
	// 설정 클래스에 @Configuration 필요
	@Test
	public void testAppConfig02() {
		// AppConfig02에 @Configuration O
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.douzone.container.config.user");
		
		User user = ac.getBean(User.class);
		assertNotNull(user);
	}
	
}
