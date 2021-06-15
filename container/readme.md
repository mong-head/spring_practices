# Container Test

* jar project

* IoC Container

## Desc

* 기본적인 configuration 알아보기
	* User
		* user, friend
	* CD, DVD
	
		<img src="https://user-images.githubusercontent.com/52481037/122005131-392c9400-cdf0-11eb-9ddd-560feedbfbd7.jpg" width="40%" />

## Test For What

* Config
	* XML Config
		* Auto Config : annotation scanning 경로 설정하면 하나하나 bean등록할 필요가 X
		* Bean Config : 각각 bean 등록 ( 잘 사용 X ) 
	* Java Config
		* Auto Config
		* Bean Config
		
* Context
	* BeanFactory (사용 잘 안함)
	* ApplicationContext (사용 많이 함)
	
## Test

* JUnit : 전체 프로그램을 돌리지 않아도 단위 테스트 가능
* Spring-test : JUnit을 spring에서 사용할 수 있도록 확장

## 설정

* pom.xml
	* spring context
	* test
		* junit : 전체 project를 구동하지 않고 단위 코드 테스트를 할 수 있게 하는 library
		* spring-test : spring 내부에서 test하기 위해 사용, JUnit기능 확장
	* test log 얻기 위한 설정
		* spring-rules : console 출력문이 잘 나왔는 지 확인하기 위해 사용
* User config
	* applicationContext01.xml : auto config
		* scan : com.douzone.container.user
	* applicationContext02.xml : bean config
		* bean 설정
	* AppConfig01.java
		* @Bean  : bean 설정
	* AppConfig02.java
		* @Bean  : bean 설정
		* @Configuration : bean singleton
* CD, DVD config

	<img src="https://user-images.githubusercontent.com/52481037/122006753-2c10a480-cdf2-11eb-8f2f-172ac4cdbe32.jpg" width="40%"/>
	
	* CDPlayerConfig.java
		* auto scanning 설정 
	* CDPlayerConfig.xml
		* auto Scanning 설정 : com.douzone.container.soundsystem
	* DVDPlayerConfig.java
		* explicit config (bean 설정)
	* DVDPlayerConfig.xml
		* explicit config

## USER description

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
		* com.douzone.container.config.user.test : 이러한 식으로 main밑에 test있는 것은 좋지 않음
			* AppConfigTest.java (java config test)
			* XmlConfigTest.java (xml config test)
	* src/test/java - JUnit
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
	

