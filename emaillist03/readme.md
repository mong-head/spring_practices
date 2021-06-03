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
		* EncodingFilter 설정
			* 이 filter는 spring-web에서 제공해줌
	* applicationContext.xml
		* scanning : Repository 경로 설정
			* spring의 3단 구성 (servlet, service, repository ) annotation 설정
				* Servlet --(사용)--> Service --(사용)--> Repository
		* 이 xml을 사용해서 Root Application Context만듦
			* ContextLoadListner 만들어지면 listener라서 ContextInitialize()가 실행되면서 application.xml참고하여 Root Application Context만듦
	* spring-servlet.xml
		* scanning : Controller 경로 설정		
		
* EmaillistController
	
	* spring-servlet.xml 참고해 만든 Web Application Context내에 위치
	* @RequestMapping 
		* method(handler) 단독 mapping
	* @Autowired 
		* 부모 Context인 Root Application Context내에 있는 EmaillistRepository 객체를 찾기 위함
		* DI(의존성 주입 - Root Context와 Web Context사이)가 잘 되어있다면 잘 wiring됨
	* @ResponseBody 
		* 안씀; 모든 handler가 jsp로 forwarding or redirecting
 		
	