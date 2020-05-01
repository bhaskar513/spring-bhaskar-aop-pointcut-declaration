package com.bhaskar.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyLoggingAspect {

	
	// this is where we add all of advice logging
	
	// start @before advice
	
	@Pointcut("execution( * com.bhaskar.aop.dao.*.*(..))")
	private void forDaoPackage() {}
	
	//create put cut to getter methos
	@Pointcut("execution( * com.bhaskar.aop.dao.*.get*(..))")
	private void getter() {}
	
	//create put cut to setter methos
	@Pointcut("execution( * com.bhaskar.aop.dao.*.get*(..))")
	private void setter() {}
	
	// include package --- exclude getter/setter
	@Pointcut("forDaoPackage() && !(getter() || setter())")
	private void forDaoPackageNoGetterSetter() {}
	
	
	@Before("forDaoPackageNoGetterSetter()")
	public void beforeAddAccountAdvice() {
		System.out.println("\n ===> executing advice on addaccount()");
		}
	
	
	@Before("forDaoPackageNoGetterSetter()")
	public void performApiAnalytics() {
		System.out.println("\n ====> Performing API analytics !!!!!!!");
	}
}
