package br.edu.web;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class WebSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebSpringApplication.class, args);
	}

}
