package org.tobby.jms.spring.server.mdp;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class ExampleMessageListener implements MessageListener{

	public void onMessage(Message message) {
		if (message instanceof TextMessage) {
			try {
				System.out.println(((TextMessage)message).getText());
			} catch (JMSException e) {
				e.printStackTrace();
			}
		} else {
			throw new IllegalArgumentException("Message must be TextMessage");
		}
		
	}

}
