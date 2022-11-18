package com.magadiflo.respuestas.app.services;

import com.magadiflo.respuestas.app.models.entity.Respuesta;

public interface IRespuestaService {

	Iterable<Respuesta> saveAll(Iterable<Respuesta> respuesta);

	Iterable<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId);

	Iterable<Long> findExamenesIdsConRespuestasPorAlumno(Long alumnoId);

	Iterable<Respuesta> findByAlumnoId(Long alumnoId);

}
