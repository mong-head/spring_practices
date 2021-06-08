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
		* console, file2, fil3 appender
			* file2 appender
				* archiving policy : file size (50kb)
				* rolling policy : 10개

			* file3 appender
				* archiving policy : file size (10kb)
				* rolling policy : 10개

		* logger
			* /ex2 : file2 appender, debug level (debug, info, warn, error)
			* /ex3 : console, file3 appender , warn level (warn, error)
			* default : console