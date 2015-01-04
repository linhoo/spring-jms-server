package org.tobby.jms.spring.server;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MapMessage;
import javax.jms.Message;
import javax.jms.TextMessage;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.support.JmsUtils;
import org.tobby.jms.spring.server.receive.MessageReceiver;
import org.tobby.jms.spring.server.util.Util;

public class ReceiveByJmsTemplate {
	
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	}
	
	private void reciveMessage(ApplicationContext context) {
		JmsTemplate jmsTemplate = (JmsTemplate)context.getBean("jmsTemplate");
		System.out.println(Util.formatDate(new Date()) + "--Start to receive message ... ");
		//Using the specified Destination
		//TextMessage message = (TextMessage)jmsTemplate.receive((Destination)context.getBean("queue"));
		//no destination specified, the jmsTemplate must have a defaultDestinationName or defaultDestination
		//Message message = jmsTemplate.receive();
		Object message = jmsTemplate.receive();
		try {
			MessageReceiver receiver = new MessageReceiver();
			if (message instanceof TextMessage) {
				receiver.processMessage(((TextMessage)message).getText());
			}
			if (message instanceof MapMessage) {
				MapMessage myMessage = (MapMessage)message;
				receiver.processMessage(myMessage.getString("password"));
				receiver.processMessage((String)myMessage.getObject("userName"));
			}
			if (message instanceof Map) {
				Map<String, Object> myMap = (Map<String, Object>)message;
				receiver.processMessage(myMap.toString());
			}
		
			
		} catch (JMSException ex) {
			throw JmsUtils.convertJmsAccessException(ex);
		}
	}
}
