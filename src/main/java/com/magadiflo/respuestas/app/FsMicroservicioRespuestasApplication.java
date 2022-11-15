package com.magadiflo.respuestas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@SpringBootApplication
public class FsMicroservicioRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsMicroservicioRespuestasApplication.class, args);
	}

}
