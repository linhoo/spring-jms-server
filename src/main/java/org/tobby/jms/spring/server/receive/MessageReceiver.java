package org.tobby.jms.spring.server.receive;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class MessageReceiver {

	public void processMessage(String message) {
		DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
		System.out.println(df.format(new Date()) + "--Received Message is : " + message);
	}

}
