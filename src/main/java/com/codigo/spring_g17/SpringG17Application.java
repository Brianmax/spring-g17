package com.codigo.spring_g17;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Scanner;

@SpringBootApplication
public class SpringG17Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringG17Application.class, args);
	}

}
