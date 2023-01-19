package com.simple.simple_batch_hello_gradle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SimpleBatchHelloGradleApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SimpleBatchHelloGradleApplication.class, args)));
	}

}
