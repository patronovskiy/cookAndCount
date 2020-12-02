package com.cookAndCount.cookAndCount;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author patronovskiy
 * @link https://github.com/patronovskiy
 * @author NuclearKat369
 * @link https://github.com/NuclearKat369
 */

@SpringBootApplication
public class CookAndCountApplication {

	private static final Logger logger = LoggerFactory.getLogger(CookAndCountApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(CookAndCountApplication.class, args);
	}

}
