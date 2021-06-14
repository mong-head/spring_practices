# Container Test

* jar project

* IoC Container

* 설정
	* pom.xml
		* spring context
		* test
			* junit : 전체 project를 구동하지 않고 단위 코드 테스트를 할 수 있게 하는 library
			* spring-test : spring 내부에서 test하기 위해 사용, JUnit기능 확장
		* test log 얻기 위한 설정
			* spring-rules : console 출력문이 잘 나왔는 지 확인하기 위해 사용
	* applicationContext01.xml : auto config
		* scan : com.douzone.container.user
	* applicationContext02.xml : bean config
		* bean 설정
	* AppConfig01.java
		* @Bean  : bean 설정
	* AppConfig02.java
		* @Bean  : bean 설정
		* @Configuration : bean singleton
	* CDPlayerConfig.java
		* auto scanning 설정 
	* CDPlayerConfig.xml
		* auto Scanning 설정 : com.douzone.container.soundsystem
	
		
## description

* eclipse
	* src/main/java
		* com.douzone.container.user
			* User.java
			* Friend.java
		* com.douzone.container.config.user 
			* AppConfig.java - java 설정
	* src/main/resources/
		* com.douzone.container.config.user
			* applicationContext.xml - xml 설정
		* com.douzone.container.config.user.test (임시 (JUnit시 없앨 것))
			* AppConfigTest.java (java config test
			* XmlConfigTest.java (xml config test)
	* src/test/java
		* com.douzone.container.user (java 및 xml 설정한 것 test)
			* AppConfigTest.java
			* XmlConfigTest.java
		
	
--> compile (jar)

	com.douzone.container.config.user
		|--- AppConfig.class (compile : java->class)
		|--- applicationContext.xml
	com.douzone.container.user
		|--- User.class
		|--- Friend.class
		|--- XmlConfigTest.class
		|--- appConfigTest.class
	
## Test For What

* Config
	
	* XML Config
		* Auto Config : annotation scanning 경로 설정하면 하나하나 bean등록할 필요가 X
		* Bean Config : 각각 bean 등록 ( 잘 사용 X ) 
	* Java Config
		* Auto Config
		* Bean Config
	
* Context
	* BeanFactory (사용X)
	* ApplicationContext (사용 O)