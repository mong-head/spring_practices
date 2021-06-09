package com.douzone.aoptest.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component // bean 설정 - applicationContext에서 scan하면서 이 class를 찾을 수 있도록 설정하는 듯
public class MyAspect {
	
	@Before("execution(public com.douzone.aoptest.vo.ProductVo com.douzone.aoptest.service.ProductService.find(String))")
	public void beforeAdvice() {
		System.out.println("---Before Advice---");
	}
	
	@After("execution(* *..*.service.ProductService.*(..))")
	public void afterAdvice() {
		System.out.println("---After Advice---");
	}
	
	@AfterReturning("execution(* *..*.ProductService.*(..))")
	public void afterReturningAdvice() {
		System.out.println("---After Returning Advice---");
	}
	
	//global exception
	@AfterThrowing(value="execution(* *..*.*.*(..))", throwing="ex") // 모든 객체에서 exception발생시
	public void afterThrowingAdvice(Throwable ex) {
		System.out.println("---After Throwing Advice:"+ ex + "---");
	}
	
	@Around("execution(* *..*.ProductService.*(..))")
	public Object aroundAdvice(ProceedingJoinPoint pjp) throws Throwable {
		// Before Advice
		System.out.println("---@Around(Before) Advice---");
		
		// PointCut Method 실행
		Object result = pjp.proceed();
			// parameter 바꿔버리기 (가로채기) : 흔하지 않음
//		Object[] params = {"Camera"};
//		Object result = pjp.proceed(params);
		
		// After Advice
		System.out.println("---@Around(After) Advice---");
		
		return result;
	}
}
