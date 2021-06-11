package com.douzone.container.config.user.test;

import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.douzone.container.config.user.AppConfig01;
import com.douzone.container.user.User;

public class AppConfigTest {

	public static void main(String[] args) {

		// Java Config test
		// 직접 java class 전달
		// 설정 class에 @Configuration 필요 X
		testAppConfig01();
		
		// Java Config02 test (AppConfig02)
		// java configuration class 있는 base package 전달
		// config class 에 @Configuration이 필요함
		testAppConfig02();
	}

	// Java Config01 test (AppConfig01)
	// 직접 java class 전달
	// 설정 class에 @Configuration 필요 X
	private static void testAppConfig01() {
		ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig01.class);

		User user = ac.getBean(User.class);
		System.out.println(user);

		((ConfigurableApplicationContext) ac).close();
	}
	
	// Java Config02 test (AppConfig02)
	// java configuration class 있는 base package 전달
	// config class 에 @Configuration이 필요함
	private static void testAppConfig02() {
		ApplicationContext ac = new AnnotationConfigApplicationContext("com.douzone.container.config.user");

		User user = ac.getBean(User.class);
		System.out.println(user);

		((ConfigurableApplicationContext) ac).close();
	}

}
