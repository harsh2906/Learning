package com.Harsh.app;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

public class Log4jExample {

	public static Logger log = LogManager.getLogger(Log4jExample.class.getName()); 
	@Test
	public void testLogger()
	{
		
		log.info("info message");
		log.debug("Debug Message");
		log.error("Error Message");
		log.fatal("Fatal Message");
	}
}
