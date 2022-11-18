package com.magadiflo.respuestas.app.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.magadiflo.commons.examenes.models.entity.Examen;

@FeignClient(name = "microservicio-examenes")
public interface IExamenFeignClient {

	@GetMapping(path = "/{id}")
	Examen obtenerExamenPorId(@PathVariable Long id);

}
