package com.simple.simple_batchapi_maven;

import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableBatchProcessing
public class SimpleBatchapiMavenApplication {

	public static void main(String[] args) {
		System.exit(SpringApplication.exit(SpringApplication.run(SimpleBatchapiMavenApplication.class, args)));
	}

}
