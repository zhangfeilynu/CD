package com.chinaredstar.cd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.scheduling.annotation.EnableScheduling;

//@SpringBootApplication(scanBasePackages = "{com.chinaredstar}")
@SpringBootApplication(scanBasePackages = { "com.chinaredstar.cd.controller", "com.chinaredstar.cd.service",
		"com.chinaredstar.cd.task" })
// @ComponentScan(basePackages = { "com.chinaredstar.cd.controller",
// "com.chinaredstar.cd.service",
// "com.chinaredstar.cd.task" })
@MapperScan(basePackages = { "com.chinaredstar.cd.dao" })
@EnableScheduling
public class CdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdApplication.class, args);
	}
}
