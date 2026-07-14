package com.codigo.spring_g17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class SpringG17Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringG17Application.class, args);
	}

}
