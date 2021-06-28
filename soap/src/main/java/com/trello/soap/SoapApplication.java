package com.trello.soap;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class SoapApplication {

    final static Logger logger = LoggerFactory.getLogger(SoapApplication.class);

    public static void main(String[] args) {
        logger.info("DEBUG:@Starting-SoapApplication");
        SpringApplication.run(SoapApplication.class, args);
    }

}
