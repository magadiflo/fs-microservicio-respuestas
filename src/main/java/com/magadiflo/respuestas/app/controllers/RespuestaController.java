package com.magadiflo.respuestas.app.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

}
