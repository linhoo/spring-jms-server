package org.tobby.jms.spring.server.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Util {

	private static DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
	
	public static String formatDate(Date date) {
		return df.format(date);
	}
}
