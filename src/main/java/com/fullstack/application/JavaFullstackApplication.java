package com.fullstack.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages="com.fullstack.*")
@EnableConfigurationProperties
@EntityScan(basePackages = {"com.fullstack.models"})
@EnableJpaRepositories(basePackages = "com.fullstack.repository")
public class JavaFullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(JavaFullstackApplication.class, args);
	} 
}


/*
 * 
 * 
 * @ComponentScan(basePackages = "com.netsurfingzone.*")
@EntityScan("com.netsurfingzone.*")
@EnableJpaRepositories(basePackages = "com.netsurfingzone.repository")

<dependency>
<groupId>org.springframework.boot</groupId>
<artifactId>spring-boot-starter-data-jpa</artifactId>
</dependency> */

