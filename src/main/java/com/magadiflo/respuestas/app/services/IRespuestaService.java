package com.magadiflo.respuestas.app.services;

import com.magadiflo.respuestas.app.models.entity.Respuesta;

public interface IRespuestaService {

	Iterable<Respuesta> saveAll(Iterable<Respuesta> respuesta);

	Iterable<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId);

}
