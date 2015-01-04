package org.tobby.jms.spring.server.mdp;

import java.util.HashMap;
import java.util.Map;

import javax.jms.JMSException;
import javax.jms.TextMessage;

public class DefaultResponsiveTextMessageDelegate implements ResponsiveTextMessageDelegate {

	public String recieve(String message) throws JMSException {
		System.out.println("Recieved Message is toby: " + message);
		return "HaaaaaaaaaaaaaHHHH";
	}

	public String recieve(HashMap message) throws JMSException {
		System.out.println("revieved map" + message);
		return "map is revieved";
	}

}
