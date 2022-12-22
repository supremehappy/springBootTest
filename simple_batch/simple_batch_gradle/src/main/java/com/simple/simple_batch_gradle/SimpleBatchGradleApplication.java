package com.simple.simple_batch_gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBatchGradleApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SimpleBatchGradleApplication.class, args)));
	}

}
