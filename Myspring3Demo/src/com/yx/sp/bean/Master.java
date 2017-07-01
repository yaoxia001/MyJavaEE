package com.yx.sp.bean;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import com.sun.istack.internal.logging.Logger;

@Component()
public class Master {
	private static Logger logger = Logger.getLogger(Master.class);
	@Autowired
	private Dog dog;
	private static ApplicationContext ctx;

	public static void main(String[] args) {
		ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
		Master m = (Master) ctx.getBean("master");
		/* logger.info(m.dog.play()); */
		System.out.println(m.dog.play());

	}

}
