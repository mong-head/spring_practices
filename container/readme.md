# Container Test

* jar project

* IoC Container

* 설정
	* pom.xml
		* spring context
	* applicationContext01.xml : auto config
		* scan : com.douzone.container.user
	* applicationContext02.xml : bean config
		* bean 설정
	* AppConfig01.java
		* @Bean  : bean 설정
	* AppConfig02.java
		* @Bean  : bean 설정
		* @Configuration : bean singleton
	
		
## description

* eclipse
	* src/main/java
		* com.douzone.container.user : User.java, Friend.java
		* com.douzone.container.config.user : AppConfig.java - java 설정
	* src/main/resources/
		* com.douzone.container.config.user : applicationContext.xml - xml 설정
		* com.douzone.container.config.user.test : AppConfigTest.java, XmlConfigTest.java (java 및 xml 설정한 것 test), 임시 (JUnit시 없앨 것)
	* src/test/java
		* com.douzone.container.user : AppConfigTest.java, XmlConfigTest.java (java 및 xml 설정한 것 test)
		
	
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