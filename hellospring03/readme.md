# 1. HelloSpring

* desc 

	* war project -> web.xml 필요
	* Spring MVC

* 설정

	<img src="https://user-images.githubusercontent.com/52481037/120432178-83575380-c3b4-11eb-96f1-c5e2319ac853.jpg" width="60%"/>

  * pom ([pom.xml](/pom.xml))
    * dependency
      * Spring context : Spring AOP, Spring Core 함께 불러와짐 (의존성 관련)
      * Spring Web MVC : servlet,listner,filter관련 - Spring자체와는 관련 X
      * Spring Web : DispatcherServlet 관련
    * plugin
      * war plugin

  * web.xml
	* DispatcherServlet 설정하기

  * spring-servlet.xml ([spring.xml](/src/main.webapp/WEB-INF/spring-servlet.xml))
	* spring-servlet에서 spring은 web.xml에서 내가 dispatcherServlet이름 설정한 이름
	*  controller 설정 시, 설정한 controller 경로 밑의 package의 controller도 모두 찾아줌
		```xml
		<context:component-scan base-package="com.douzone.hellospring.springex.controller" />
		```
	* 3버전 전에(annotaion)이 없는 경우, controller 이외에도 handler도 여기에서 설정해줬음. 현재는 위의 줄 처럼 controller만 설정해주면 @RequestMapping이라는 annotation을 보고 handler mapping을 할 수 있음
		```xml
		<bean  id="urlMapping" class="org.springframework.web.servlet.handler.SimpleUrlHandlerMapping" >
		     <property name="mappings">
		           <props>
			  <prop key="/member">memberController</prop>
		           </props>
		     </property>
		</bean>
		
		<bean id=" memberController" class= "com.example.controller.MemberController"> 
		```
	* interceptor 설정
  * targeted runtime 설정 : Apache tomcat v8.5 체크
  * maven -> update 시키기
		
## 1. Spring에서 Request처리 후 Response 과정

<img src="https://user-images.githubusercontent.com/52481037/120448808-e4882280-c3c6-11eb-87ab-f13c9998bbb3.jpg" width="60%"/>

* request : hellospring03/hello
  * tomcat의 DispatcherServlet으로 감
    * DispatcherServlet은 Spring Web 관련
* DispatcherServlet
  * init()
    * Web Application Context생성
      * HandlerMapping : controller 내의 handler 정보 있는 객체; @RequestBody등의 annotation 여부도 저장되어 있음
      * ViewResolver : handler가 @RequestBody가 없는 경우 사용
      * MessageConverter : @RequestBody가 있는 경우 사용; string이나 object를 message로 변환
    * DispatcherServlet은 Handler Mapping을 참조하게 됨
  * service()
  * doGet()
    * HandlerMapping에서 /hello(url)의 controller찾아서 controller의 hello method 실행
    * @RequestBody
      * 없는 경우 : return값인 String이나 Model에서 ViewName을 뽑아 내어 jsp로 감 -> response
      * 있는 경우 : String이나 Object에서 HTML등의 내용을 변환하여 바로 browser화면에 메세지 출력 -> response

## 2. @RequestBody 연습

* Controller인 경우 @Controller annotation사용해야 HandlerMapping객체가 찾을 수 있음

* RequestBody 없는 경우 : forwarding (jsp)
	* HelloController
		* return string OR return ModelAndView
		* Model이 나오면 무조건 jsp로 넘긴다고 생각하면 됨
		
* RequestBody 있는 경우 : 바로 browser로 message보냄
	* GuestbookController
		* return한 string이 browser에 그대로 출력되는 모습을 볼 수 있음

## 3. @RequestMappping 연습

1. method(handler) 단독 mapping
	* class에는 annotation사용하지 않고, handler에 사용
	* BoardController

2. class type mapping
	* class에만 annotaion 사용
	* GuestbookController

3. class + handler (good)
	* class에도 annotation사용, method(handler)에도 annotation 사용
	* UserController

* UserController 방식(class에도 mapping, method에도 mapping) 많이 볼 것임

## 4. @RequestParam 연습

* Restful; CRUD method에 따라 같은 url임에도 다르게 행동하도록 할 수 있음

	* CRUD
	
	    ```jsx
	    // READ
	    GET /board               : list
	    GET /board/{no}          : view (MVC servlet 사용 시 /board?a=view&no=...)
	
	    // CREATE
	    POST /board              : insert (MVC servlet사용 시 /board?a=insert)
	    ------------------
	    title=....&contents=..... (data옴)
	
	    // DELETE
	    DELETE /board/{no}       : delete (MVC servlet사용 시 /board?a=delete&no=...)
	
	    // UPDATE
	    PUT /board/{no}          : update (MVC servlet사용 시 /board?a=update&no=...)
	    ```

* UserController

	```java
	public String update2(
				@RequestParam(value="n", required=true, defaultValue="") String name,
				@RequestParam(value="a", required=true, defaultValue="0") int age) {
			System.out.println("---" + name + ":" + age);
	```
	* defaultValue 설정 시 n parameter가 없이 와도 400 error내지 않도록 value를 설정해줄 수 있음 
	* defaultValue는 param이 int여도 무조건 String으로 설정해줌

## 5. Interceptor

* MyInterceptor01 : implements HandlerInterceptor
	* preHandler : request 받는 것 관련
	* postHandler : response받고 처리
	* afterCompletion : response받음. view resolver, view 관련
* MyInterceptor02 : extends HandlerInterceptorAdapter
	* preHandler