package org.tobby.jms.spring.server.annotation;

import java.util.Map;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.validation.Valid;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
public class AnnotatedJMSListener implements MessageListener {

	@JmsListener(destination="mailbox-destination")
	@SendTo("text-dest")
	public String processOrder(Message message, Session session, 
			org.springframework.messaging.Message<String> text,
			@Header("jms_destination") String destination,
			@Headers Map<String, Object> headers,
			@Valid String payload) throws JMSException {
		System.out.println("This is the annotated Message : " + ((TextMessage)message).getText());
		System.out.println(session.getAcknowledgeMode());
		System.out.println(text);
		System.out.println(text.getPayload());
		System.out.println(text.getHeaders());
		System.out.println(destination);
		System.out.println(headers.get("jms_destination"));
		System.out.println(headers);
		System.out.println("I am payload -- " + payload);
		return "I LOVE YOU";
	}

	public void onMessage(Message message) {
		try {
			System.out.println("This is the MessageListener LOG -" + ((TextMessage)message).getText());
		} catch (JMSException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
