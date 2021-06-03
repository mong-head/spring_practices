# emaillist03

* desc
	* war project - web.xml 필요
	
* 설정
	* pom.xml
		* spring web mvc, context, mvc
		* jstl
		* mariadb
		* build 설정
	* web.xml
		* applicationContext.xml (root application context) 설정
			* listener에서 사용할 Context Parameter설정
		* spring-servlet.xml (web application context) 설정
			* servlet
	* applicationContext.xml
		* scanning : Repository 경로 설정
			* spring의 3단 구성 (servlet, service, repository ) annotation 설정
				* Servlet --(사용)--> Service --(사용)--> Repository
		* 이 xml을 사용해서 Root Application Context만듦
			* ContextLoadListner 만들어지면 listener라서 ContextInitialize()가 실행되면서 application.xml참고하여 Root Application Context만듦
	* spring-servlet.xml
		* controller 경로 설정		
	