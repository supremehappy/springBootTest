package com.simple.simple_batch_hello_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBatchHelloMavenApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SimpleBatchHelloMavenApplication.class, args)));
	}

}
