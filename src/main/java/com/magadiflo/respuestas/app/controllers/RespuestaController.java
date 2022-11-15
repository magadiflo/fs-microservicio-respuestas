package com.magadiflo.respuestas.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.magadiflo.respuestas.app.models.entity.Respuesta;
import com.magadiflo.respuestas.app.services.IRespuestaService;

@RestController
public class RespuestaController {

	private final IRespuestaService respuestaService;

	public RespuestaController(IRespuestaService respuestaService) {
		this.respuestaService = respuestaService;
	}

	@PostMapping
	public ResponseEntity<?> crear(@RequestBody Iterable<Respuesta> respuestas) {
		Iterable<Respuesta> respuestasBD = this.respuestaService.saveAll(respuestas);
		return ResponseEntity.status(HttpStatus.CREATED).body(respuestasBD);
	}

	@GetMapping(path = "/alumno/{alumnoId}/examen/{examenId}")
	public ResponseEntity<?> obtenerRespuestaPorAlumnoYExamen(@PathVariable Long alumnoId,
			@PathVariable Long examenId) {
		Iterable<Respuesta> respuestas = this.respuestaService.findRespuestasByAlumnoByExamen(alumnoId, examenId);
		return ResponseEntity.ok(respuestas);
	}

	@GetMapping(path = "/alumno/{alumnoId}/examenes-respondidos")
	public ResponseEntity<?> obtenerExamenesIdsConRespuestasAlumno(@PathVariable Long alumnoId) {
		Iterable<Long> examenesId = this.respuestaService.findExamenesIdsConRespuestasPorAlumno(alumnoId);
		return ResponseEntity.ok(examenesId);
	}

}
