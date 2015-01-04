package org.tobby.jms.spring.server.mdp;

import java.io.Serializable;
import java.util.Map;

public interface MessageDelegate {
	
	void handleMessage(String messsage);
	
	void handleMessage(Map message);
	
	void handleMessage(byte[] message);
	
	void handleMessage(Serializable message);
	
}
