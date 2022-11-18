package com.magadiflo.respuestas.app.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.magadiflo.commons.examenes.models.entity.Examen;

@FeignClient(name = "microservicio-examenes")
public interface IExamenFeignClient {

	@GetMapping(path = "/{id}")
	Examen obtenerExamenPorId(@PathVariable Long id);

	@GetMapping(path = "/respondidos-por-preguntas")
	List<Long> obtenerExamenesIdsPorPreguntasIdRespondidas(@RequestParam List<Long> preguntaIds);

}
