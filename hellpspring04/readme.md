# hellospring04

* war project

* web 관련 servlet-spring.xml 이나 applicationContext.xml 대신 java 설정 파일 설정해보기

* 설정 
	* pom.xml
	* web.xml
		* DispatcherServlet 설정
			* init-param
				<img src="https://user-images.githubusercontent.com/52481037/121977042-08346b00-cdc0-11eb-97a5-b0c91a847920.jpg" width="30%"/>
				* contextLocation : AnnotationConfigWebApplication 
				* contextConfigLocation : spring-servlet.xml 대신 WebConfig.java 설정 경로
	* WebConfig.java (spring-servlet.xml 대신)
		* web mvc 설정
		* auto scan 설정 : controller