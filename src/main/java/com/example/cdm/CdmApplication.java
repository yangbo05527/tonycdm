package com.example.cdm;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@ComponentScan(basePackages={"com.example.cdm.*"})
@MapperScan(basePackages = "com.example.cdm.dao")
public class CdmApplication {

	public static void main(String[] args) {
		SpringApplication.run(CdmApplication.class, args);
	}


}
