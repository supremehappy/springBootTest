package com.simple.simple_batch_maven;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBatchMavenApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SimpleBatchMavenApplication.class, args)));
	}

}
