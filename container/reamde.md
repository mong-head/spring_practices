# Container Test

* jar project

* IoC Container

* 설정
	* pom.xml
		* spring context
	* applicationContext01.xml : auto config
		* scan : com.douzone.container.user
	* applicationContext02.xml : bean config
		* 
		
## description

* eclipse
	* src/main/java
		* com.douzone.container.user : User.java, Friend.java
		* com.douzone.container.user.test : AppConfigTest.java, XmlConfigTest.java (java 및 xml 설정한 것 test), 임시 (JUnit시 없앨 것)
		* com.douzone.container.config.user : AppConfig.java - java 설정
	* src/main/resources/
		* com.douzone.container.config.user : applicationContext.xml - xml 설정
	* src/test/java
		* com.douzone.container.user : AppConfigTest.java, XmlConfigTest.java (java 및 xml 설정한 것 test)
		
	
--> compile (jar)
	```text
	com.douzone.container.config.user
		|--- AppConfig.class (compile : java->class)
		|--- applicationContext.xml
	com.douzone.container.user
		|--- User.class
		|--- Friend.class
		|--- XmlConfigTest.class
		|--- appConfigTest.class
	```
	
## Test For What

* XML Config
	* Auto Config : annotation scanning
	* Bean Config