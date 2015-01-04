package org.tobby.jms.spring.server.mdp;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public interface ResponsiveTextMessageDelegate {

	String recieve(String message) throws JMSException;
	
	String recieve(HashMap message) throws JMSException;
	
}
