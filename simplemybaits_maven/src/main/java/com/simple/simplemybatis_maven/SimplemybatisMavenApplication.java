package com.simple.simplemybatis_maven;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan(basePackageClasses = SimplemybatisMavenApplication.class)
@SpringBootApplication
public class SimplemybatisMavenApplication {

	public static void main(String[] args) {
		SpringApplication.run(SimplemybatisMavenApplication.class, args);
	}

}
