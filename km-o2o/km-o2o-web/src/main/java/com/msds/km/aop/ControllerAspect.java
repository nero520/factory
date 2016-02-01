package com.msds.km.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.msds.util.JsonUtils;

/**
 * 接口调试阶段使用
 * 
 * @Description TODO
 * @author LiLong
 * @date 2015年11月4日14:38:30
 */
@Aspect
@Component
public class ControllerAspect {

	private static final Logger logger = LoggerFactory
			.getLogger(ControllerAspect.class);

	private ControllerAspect() {
	}

	/**
	 * 方法返回值
	 * 
	 * @param joinPoint
	 * @param retVal
	 */
	@AfterReturning(value = "execution(* com.msds.km.controller.*.*(..))", returning = "retVal")
	public void afterReturning(JoinPoint joinPoint, Object retVal) {// ProceedingJoinPoint
		if (retVal != null) {
			logger.info("\r\n返回:\r\n{}", JsonUtils.toJson(retVal));
		}
	}

}
