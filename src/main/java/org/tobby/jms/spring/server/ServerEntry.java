package org.tobby.jms.spring.server;

import java.util.Date;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.tobby.jms.spring.server.receive.MessageReceiver;
import org.tobby.jms.spring.server.util.Util;

public class ServerEntry {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		JmsTemplate jmsTemplate = (JmsTemplate)context.getBean("jmsTemplate");
		System.out.println(Util.formatDate(new Date()) + "Start to receive message ... ");
		TextMessage message = (TextMessage)jmsTemplate.receive((Destination)context.getBean("queue"));
		try {
			String text = message.getText();
			MessageReceiver receiver = new MessageReceiver();
			receiver.processMessage(text);
		} catch (JMSException ex) {
			throw JmsUtils.convertJmsAccessException(ex);
		}
	}
}
