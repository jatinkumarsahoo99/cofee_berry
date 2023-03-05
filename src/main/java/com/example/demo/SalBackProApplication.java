package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SalBackProApplication {

	/*
	 * @Bean public PasswordEncoder passwordEncoder() { PasswordEncoder encoder =
	 * new BCryptPasswordEncoder(); return encoder; }
	 */

	public static void main(String[] args) {
		SpringApplication.run(SalBackProApplication.class, args);
	}

}
