# logex

* logging 연습

* 설정
	* pom.xml (src/main/webapp/WEB-INF 밑)
		 * spring
		 	* common-logging (JCL) 제외 : SLF4J의 구현체인 LogBack library를 logger로 사용할 것이기 때문
		 * spring web, mvc
		 * LogBack 
	* spring-servlet.xml (src/main/webapp/WEB-INF 밑)
		* com.douzone밑 모두 scan
		 
	* logback.xml (src/main/resources 밑)