package org.tobby.jms.spring.server.mdp;

import java.io.Serializable;
import java.util.Map;

public class DefaultMessageDelegate implements MessageDelegate {

	public void handleMessage(String messsage) {
		System.out.println(messsage);
	}

	public void handleMessage(Map message) {
		System.out.println(message);
	}

	public void handleMessage(byte[] message) {
		System.out.println(message);
	}

	public void handleMessage(Serializable message) {
		System.out.println(message);
	}

}
