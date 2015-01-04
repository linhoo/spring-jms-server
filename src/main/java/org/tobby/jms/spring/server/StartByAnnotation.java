package org.tobby.jms.spring.server;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class StartByAnnotation {

	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("org.tobby");
		//context.register(AppConfig.class);
		//context.scan("org.tobby.jms.spring.server.annotation");
		//context.refresh();
	}
}
