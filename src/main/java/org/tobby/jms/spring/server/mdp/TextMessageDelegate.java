package org.tobby.jms.spring.server.mdp;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.springframework.jms.JmsException;

public interface TextMessageDelegate {

	void recieve(TextMessage message) throws JMSException;
	
}
