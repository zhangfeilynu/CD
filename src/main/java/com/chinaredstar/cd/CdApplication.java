package com.chinaredstar.cd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@SpringBootApplication(scanBasePackages = "{com.chinaredstar}")
@SpringBootApplication
@ComponentScan(basePackages = { "com.chinaredstar.cd.controller", "com.chinaredstar.cd.service" })
@MapperScan(basePackages = { "com.chinaredstar.cd.dao" })
public class CdApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdApplication.class, args);
	}
}
