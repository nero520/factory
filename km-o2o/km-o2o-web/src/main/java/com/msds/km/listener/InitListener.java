package com.msds.km.listener;

import java.util.logging.Logger;

import javax.servlet.ServletContext;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;
import org.springframework.web.context.ServletContextAware;

/**
 * 初始化动作
 * 
 * @ClassName InitListener
 * @Description TODO
 * @author LiLong
 * @date 2014年11月24日 上午10:06:25
 * 
 */
@Component("initListener")
public class InitListener implements ServletContextAware,
		ApplicationListener<ContextRefreshedEvent> {

	/** logger */
	private static final Logger logger = Logger.getLogger(InitListener.class
			.getName());

	/** servletContext */
	private ServletContext servletContext;

	public void setServletContext(ServletContext servletContext) {
		this.servletContext = servletContext;
	}

	public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
		if (servletContext != null
				&& contextRefreshedEvent.getApplicationContext().getParent() == null) {
			logger.info("***********康众 O2O-web 启动成功***********");
		}
	}

}