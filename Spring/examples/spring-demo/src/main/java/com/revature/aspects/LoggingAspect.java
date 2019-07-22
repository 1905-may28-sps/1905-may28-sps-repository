package com.revature.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/*
 * In AOP (Aspect Oriented Programming), our classes
 * represent Aspects instead of objects
 * 
 * AOP is defined as the modularization of cross cutting
 * concerns. Meaning, in terms that make sense to normal 
 * humans, separating tasks that apply to multiple layers
 * of code in our app (ie dao, controllers, and service) 
 * into their own bodies of code as to make them their own 
 * 
 * An Aspect holds behavior (advices are our methods) that we 
 * wish for Spring to apply to other methods in our app 
 */
@Aspect
@Component
public class LoggingAspect {
	
	private final Log logger = LogFactory.getLog(this.getClass());
	
	/*
	 * ADVICE (methods in an aspect class)
	 * Each type of advice(Before, After, AfterThrowing, 
	 * AfterReturning, Around) is the annotation itself, 
	 * NOT @Advice. 
	 * 
	 * Following the advice annotation, comes our POINTCUT
	 * The pointcut is the set of points in execution of your 
	 * code at which you want your advice to be applied 
	 * "Where do i want this advice to happen"
	 * meanwhile the type of advice shows us "when" we 
	 * want it to happen
	 * In spring, our pointcuts represent method executions
	 * based on method names and locations
	 * below, we see that we will execute this method
	 * BEFORE the EXECUTION of methods with any(*) return
	 * type, in the com.revature base package. in any sub-package
	 * of that base package, in any class in any of those 
	 * packages, and finally, in any method in any of those
	 * classes, with any parameter list (..)
	 * 
	 * () com.revature.controllers.PhoneController.getAll()
	 * * com.revature.controllers.*.* (..)
	 */
	
	@Before("allMethods()")
	public void beforeDemo(JoinPoint jp) {
	//	System.out.println("CALLING METHOD: " + jp.getSignature());
		System.out.println("CALLING METHOD: " + jp.getSignature() + "\n"
				+ "SOURCE LOCATION: " + jp.getSourceLocation() + "\n"
				+ "ARGUMENTS: " + jp.getArgs() + "\n" 
				+ "TARGET OBJECT: " + jp.getTarget() + "\n -----------------------------" );
	}
	
	@Pointcut("execution(* com.revature.*.*.*(..))")
	public void allMethods() {}
	
	@Around("execution(* com.revature.controllers.*.*(..))")
	public Object aroundControllerMethods(ProceedingJoinPoint pjp) {
		System.out.println("BEFORE METHOD EXECUTION");
		Object toReturn = null;
		try {
			toReturn = pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AFTER METHOD EXECUTION");
		return toReturn;
	}
	
	/*@Around("execution(* com.revature.controllers.*.*(..))")
	public void aroundControllerMethods(ProceedingJoinPoint pjp) {
		System.out.println("BEFORE METHOD EXECUTION");
	
		try {
			pjp.proceed();
		} catch (Throwable e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("AFTER METHOD EXECUTION");
		
	}*/
	
	

}
