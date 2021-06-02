# 1. HelloSpring


* 설정

<img src="https://user-images.githubusercontent.com/52481037/120432178-83575380-c3b4-11eb-96f1-c5e2319ac853.jpg" width="60%"/>

  * pom ([pom.xml](/pom.xml))
    * dependency
      * Spring context : Spring AOP, Spring Core 함께 불러와짐 (의존성 관련)
      * Spring Web MVC : servlet,listner,filter관련 - Spring자체와는 관련 X
      * Spring Web : DispatcherServlet 관련
    * plugin
      * war plugin

## 1. Spring에서 Request처리 후 Response 과정

<img src="https://user-images.githubusercontent.com/52481037/120448808-e4882280-c3c6-11eb-87ab-f13c9998bbb3.jpg" width="60%"/>

1. request : hellospring03/hello
  * tomcat의 DispatcherServlet으로 감
    * DispatcherServlet은 Spring Web 관련
2. DispatcherServlet
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

## 1. @RequestMapping, @RequestBody 연습

