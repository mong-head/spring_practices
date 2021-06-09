# Aop Test

* jar project

* 설정
	* pom.xml
		* spring context
		* spring aspects
	* applicationContext.xml (src/main/resources)
		* auto proxy 설정 : 자동으로 @Aspect가 적용된 bean을 aspect로 사용할 수 있게 함
		* service, aspect 경로 scanning 설정
		
## Description

### 0. 개요


### 1. Advisor 작성 (5개) ([aspect.MyAspect](/src/main/java/com/douzone/aoptest/aspect/MyAspect.java))

- before :  method block 실행 전
- after : method block 실행 후
- around (:star:)
	* 많이 사용
	* method의 parameter 변경 가능 (잘 하지는 않음)
	* method의 시간 측정 가능
- after return : 값을 return한 후에
- after throwing : exception 발생 후에
	* 확인하려고 일부러 ProductService에서 exception발생시킴

### 2. 결과

#### 1) exception 발생하지 않은 경우

* @Around에서 parameter 바꾸지 않는 경우

	```text
	---@Around(Before) Advice---
	---Before Advice---
	[ProductService] finding...
	---@Around(After) Advice---
	---After Advice---
	---After Returning Advice---
	[main] ProductVo [name=TV]
	```

* @Around에서 parameter(Camera로) 바꾸는 경우 (거의 안함)

	```text
	---@Around(Before) Advice---
	---Before Advice---
	[ProductService] finding...
	---@Around(After) Advice---
	---After Advice---
	---After Returning Advice---
	[main] ProductVo [name=Camera]
	```

#### 2) exception 발생한 경우

	```text
	---@Around(Before) Advice---
	---Before Advice---
	[ProductService] finding...
	---After Advice---
	---After Throwing Advice:java.lang.RuntimeException: Find Exception---
	```

### 3. Point Cut 기술 방법

* 접근지시자는 생략가능
	* public 대신 * 로 대체많이 함
	```java
	@After("execution(public com.douzone.~~))
	```
	```java
	@After("execution(* com.douzone.~~))
	```
* 긴 package 이름 대체
	* *..*

* parameter는 잘 명시하지 않음
	* ..
	
* method 명시 안할 떄
	* * 로 작성
	
## 실행결과
