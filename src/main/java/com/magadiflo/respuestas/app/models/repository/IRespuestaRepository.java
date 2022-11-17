package com.magadiflo.respuestas.app.models.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.magadiflo.respuestas.app.models.entity.Respuesta;

public interface IRespuestaRepository extends CrudRepository<Respuesta, Long> {
	/**
	 * JOIN FETCH r.alumno, esto no iría ya que hicimos un cambio en la entity
	 * Respuesta. Esto es así, por que no tenemos la relación con Alumno, que ahora
	 * mismo ya es @Transient, por lo tanto el JOIN FETCH r.alumno no va, no es
	 * parte del Entity, es un atributo de la clase.
	 * 
	 */
	@Query("SELECT r FROM Respuesta AS r JOIN FETCH r.pregunta AS p JOIN FETCH p.examen AS e WHERE r.alumnoId = ?1 AND e.id = ?2")
	Iterable<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId);

	// Aquí el FETCH no va, ese FETCH solo lo usamos cuando queremos retornar el
	// objeto con los demás objetos relacionados. Por otro lado, con el Group by
	// para que no se repitan los ids
	@Query("SELECT e.id FROM Respuesta AS r JOIN r.pregunta AS p JOIN p.examen AS e WHERE r.alumnoId = ?1 GROUP BY e.id")
	Iterable<Long> findExamenesIdsConRespuestasPorAlumno(Long alumnoId);

}