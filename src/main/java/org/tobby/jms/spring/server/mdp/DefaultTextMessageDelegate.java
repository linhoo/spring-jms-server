package org.tobby.jms.spring.server.mdp;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class DefaultTextMessageDelegate implements TextMessageDelegate {

	public void recieve(TextMessage message) throws JMSException {
		System.out.println(message.getText());
	}

}
