package com.Atm.ATM;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
@SpringBootApplication

public class AtmApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtmApplication.class, args);
	}

}
