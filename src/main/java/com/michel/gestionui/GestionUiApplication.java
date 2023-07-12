package com.michel.gestionui;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class GestionUiApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionUiApplication.class, args);
	}

}
