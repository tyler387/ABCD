package com.kh.jaManChw.util.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	
	@Before("bean(*Controller)")
	public void logCon(JoinPoint jp) { 
		logger.info("##### {}", jp.getSignature().toShortString().replace("."," - "));	
	}
	
	@Before("bean(*Service)")
	public void logSer(JoinPoint jp) {
		logger.info("##### {}", jp.getSignature().toShortString().replace("."," - "));
		
	}
}
