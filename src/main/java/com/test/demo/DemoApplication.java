package com.test.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@EnableAspectJAutoProxy
@ComponentScan(basePackages = {
		"com.test.demo.controller",
		"com.test.demo.service",
		"com.test.demo.aspect",
        "com.test.demo.configuration",
		"com.test.demo.advice",
		"com.test.demo.dto",
		"com.test.demo.event",
		"com.test.demo.exception",})
public class DemoApplication {
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

}
