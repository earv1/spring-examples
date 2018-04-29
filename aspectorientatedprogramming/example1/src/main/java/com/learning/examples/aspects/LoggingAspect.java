package com.learning.examples.aspects;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class LoggingAspect {

	@Before("execution(* com.learning.examples.libraries..*(..))")
	public void logBefore(JoinPoint joinPoint) {

		System.out.println("Wow Alfred, good job on the new surveillance system");
		System.out.println("hijacked : " + joinPoint.getSignature().getName());
		System.out.println("******");
	}

}
