package library.exception;

import org.apache.log4j.Logger;

public class Log4j {

	private static final Logger logger = Logger.getLogger(Log4j.class);
	
	public static Logger getInstance() {
		return logger;
	}

}
