package com.magadiflo.respuestas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@EnableEurekaClient
@EntityScan(value = { "com.magadiflo.respuestas.app.models.entity", "com.magadiflo.commons.alumnos.models.entity", "com.magadiflo.commons.examenes.models.entity" })
@SpringBootApplication
public class FsMicroservicioRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsMicroservicioRespuestasApplication.class, args);
	}

}
