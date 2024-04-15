package com.hglobal.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
public class MultipledatabasesApplication {

	public static void main(String[] args) {
		SpringApplication.run(MultipledatabasesApplication.class, args);
	}

}
