package org.tobby.jms.spring.server.mdp;

import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.springframework.jms.listener.SessionAwareMessageListener;

public class SessionAwareMessageListenerExample implements SessionAwareMessageListener<Message> {
	
	private Destination destination;

	public void onMessage(Message message, Session session) throws JMSException {
		if (message instanceof TextMessage) {
			System.out.println(((TextMessage)message).getText());
			MessageProducer producer = session.createProducer(destination);
			TextMessage textMessage = session.createTextMessage("ConsumerSessionAwareMessageListener");
			producer.send(textMessage);
		} else {
			throw new IllegalArgumentException("Message must be text message");
		}
	}

	public Destination getDestination() {
		return destination;
	}

	public void setDestination(Destination destination) {
		this.destination = destination;
	}

}
