package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = {"com.example.demo","com.example.service","com.example.swagger"})
public class IstioGatewayApplication {

	public static void main(String[] args) {
		
		  SpringApplication.run(IstioGatewayApplication.class, args);
		/*
		 * SpringApplication o=new SpringApplication();
		 * 
		 * new SpringApplicationBuilder(IstioGatewayApplication.class)
		 * .properties("spring.config.name=application,application.yml") .run(args);
		 */
	}

}
