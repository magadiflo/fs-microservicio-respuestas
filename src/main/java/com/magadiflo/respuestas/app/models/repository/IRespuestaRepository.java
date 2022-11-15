package com.magadiflo.respuestas.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.magadiflo.respuestas.app.models.entity.Respuesta;

public interface IRespuestaRepository extends CrudRepository<Respuesta, Long> {

	@Query("SELECT r FROM Respuesta AS r JOIN FETCH r.alumno AS a JOIN FETCH r.pregunta AS p JOIN FETCH p.examen AS e WHERE a.id = ?1 AND e.id = ?2")
	Iterable<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId);

}