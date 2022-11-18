package com.magadiflo.respuestas.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * Como las librerías commons-alumnos y commons-examenes tienen Data JPA y y
 * esas librerías la estamos usando en este proyecto, Spring se quejará y dirá:
 * "No se pudo configurar un origen de datos: el atributo 'url' no está
 * especificado y no se pudo configurar ningún origen de datos incrustado", es
 * decir no tenemos configuración para JPA, pero nosotros no estamos usando JPA
 * en este proyecto así que excluiremos el DataSourceAutoConfiguration, porque
 * no estmos usando JPA sino MongoDB
 *
 */
@EnableAutoConfiguration(exclude = { DataSourceAutoConfiguration.class })
@EnableFeignClients
@EnableEurekaClient
@SpringBootApplication
public class FsMicroservicioRespuestasApplication {

	public static void main(String[] args) {
		SpringApplication.run(FsMicroservicioRespuestasApplication.class, args);
	}

}
