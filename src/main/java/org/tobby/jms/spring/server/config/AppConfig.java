package org.tobby.jms.spring.server.config;

import javax.jms.ConnectionFactory;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.annotation.JmsListenerConfigurer;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerEndpointRegistrar;
import org.springframework.jms.config.SimpleJmsListenerEndpoint;
import org.springframework.messaging.handler.annotation.support.DefaultMessageHandlerMethodFactory;
import org.springframework.validation.Validator;
import org.tobby.jms.spring.server.annotation.AnnotatedJMSListener;
import org.tobby.jms.spring.server.validate.MyValidator;

@Configuration
@EnableJms
public class AppConfig implements JmsListenerConfigurer {

	@Bean
	public DefaultJmsListenerContainerFactory jmsListenerContainerFactory() {
		DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
		factory.setConnectionFactory(connectionFactory());
		factory.setConcurrency("3-10");
		return factory;
	}
	
	@Bean
	public ConnectionFactory connectionFactory() {
		ActiveMQConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
		connectionFactory.setBrokerURL("tcp://localhost:61616");
		return connectionFactory;
	}

	public void configureJmsListeners(JmsListenerEndpointRegistrar registrar) {
		SimpleJmsListenerEndpoint endpoint = new SimpleJmsListenerEndpoint();
		endpoint.setDestination("text-dest");
		endpoint.setMessageListener(new AnnotatedJMSListener());
		endpoint.setId("111");
		registrar.registerEndpoint(endpoint);
		registrar.setMessageHandlerMethodFactory(myJmsHandlerMethodFactory());
	}
	
	@Bean
	public DefaultMessageHandlerMethodFactory myJmsHandlerMethodFactory() {
		DefaultMessageHandlerMethodFactory factory = new DefaultMessageHandlerMethodFactory();
		factory.setValidator(myValidator());
		return factory;
	}
	
	public Validator myValidator() {
		return new MyValidator();
	}
}
