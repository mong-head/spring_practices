package com.douzone.container.config.user.test;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import com.douzone.container.user.User;
import com.douzone.container.user.User1;

public class XmlConfigTest {

	public static void main(String[] args) {

		// bean factory test : 나중에는 거의 안씀
		// XML Config - auto config test (Annotation Scanning)
		testBeanFactory01();

		// XML Config - bean config test (Explicit Configuration) : 명시적 bean 설정
		testBeanFactory02();

		// ApplicationContext test : 이거 사용
		// XML Auto Configuration (Annotation Scanning)
		testApplicationContext01();

		// XML Bean Configuration (Explicit Configuration)
		testApplicationContext02();

	}

	// XML Config - auto config test (Annotation Scanning)
	private static void testBeanFactory01() {
		System.out.println("XML Auto Config : beanFactory Container사용");

		// 안쓰는 표현
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext01.xml"));

		User1 user1 = bf.getBean(User1.class); // good 방식
		System.out.println(user1.getName());

		// Bean id 자동으로 설정됨
		user1 = (User1) bf.getBean("user1"); // mistcasting 위험 있음
		System.out.println(user1.getName());
	}

	// XML Config - bean config test (Annotation Scanning)
	private static void testBeanFactory02() {

		System.out.println("XML bean Config : beanFactory Container사용");

		// 안쓰는 표현
		BeanFactory bf = new XmlBeanFactory(
				new ClassPathResource("com/douzone/container/config/user/applicationContext02.xml"));

		User1 user1 = bf.getBean(User1.class); // good 방식
		System.out.println(user1.getName());

		// Bean id 자동으로 설정안됨 - 명시적으로 id를 설정해야함
		user1 = (User1) bf.getBean("user1"); // mistcasting 위험 있음
		System.out.println(user1.getName());
	}

	// XML Auto Config; 많이 사용하는 표현 사용
	private static void testApplicationContext01() {

		System.out.println("XML Auto Config : ApplicationContext Container사용");

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext01.xml");

		User1 user1 = ac.getBean(User1.class);
		System.out.println(user1.getName());

		user1 = (User1) ac.getBean("user1"); // mistcasting 위험 있음
		System.out.println(user1.getName());

		// 자원정리
		((ConfigurableApplicationContext) ac).close();
	}

	// XML Bean Config; 많이 사용하는 표현 사용
	private static void testApplicationContext02() {

		System.out.println("XML Bean Config : ApplicationContext Container사용");

		ApplicationContext ac = new ClassPathXmlApplicationContext(
				"com/douzone/container/config/user/applicationContext02.xml");

		// id로 bean 가지고 오기 (사용 O)
		User user = (User) ac.getBean("user");
		System.out.println(user);

		// name으로 bean 가지고 오기 (사용 X)
		user = (User) ac.getBean("usr");
		System.out.println(user);

		// class type으로 bean 가지고 오기
		// 같은 type의 bean이 2개 이상 존재하는 경우 type으로 가지고 오면 error남
		// 1. type + id
		user = ac.getBean("user2", User.class);
		System.out.println(user);
		// 2. type + name
		user = ac.getBean("usr2", User.class);
		System.out.println(user);

		// 2개 parameter 생성자로 생성된 bean 가지고 오기
		user = ac.getBean("user3", User.class);
		System.out.println(user);

		user = ac.getBean("user4", User.class);
		System.out.println(user);
		
		// setter 사용한 bean 가지고 오기
		user = ac.getBean("user5", User.class);
		System.out.println(user);
		
		// setter, DI 사용한 bean 가지고 오기
		user = ac.getBean("user6", User.class);
		System.out.println(user);
		
		// setter 사용 bean 가지고 오기 (list setter사용)
		user = ac.getBean("user7", User.class);
		System.out.println(user);

		// 자원정리
		((ConfigurableApplicationContext) ac).close();
	}
}
