package com.douzone.container.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {
		
		// XML Config - auto config test (Annotation Scanning)
		//bean factory test : 나중에는 거의 안씀
		testBeanFactory01();
		
		// XML Config - bean config test (Explicit Configuration) : 명시적 bean 설정
		//testBeanFactory02();
		
	}
	
	// XML Config - auto config test (Annotation Scanning)
	private static void testBeanFactory01() {
		// 안쓰는 표현
		BeanFactory bf = new XmlBeanFactory(new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml")); 
		
		User1 user1 = bf.getBean(User1.class); //good 방식
		System.out.println(user1.getName());
		
		// Bean id 자동으로 설정됨
		user1 = (User1)bf.getBean("user1"); // mistcasting 위험 있음
		System.out.println(user1.getName());
	}

}
