package com.exampleproject.springregister;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringRegisterApplication {

	private static final Logger logger = LogManager.getLogger(SpringRegisterApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SpringRegisterApplication.class, args);
		logger.trace("Trace!");
		logger.debug("Debug!");
		logger.info("Info!");
		logger.warn("Warn!");
		logger.error("Error!");
		logger.fatal("Fatal!");
	}
}