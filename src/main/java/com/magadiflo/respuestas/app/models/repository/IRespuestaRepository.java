package com.magadiflo.respuestas.app.models.repository;

import org.springframework.data.repository.CrudRepository;

import com.magadiflo.respuestas.app.models.entity.Respuesta;

public interface IRespuestaRepository extends CrudRepository<Respuesta, Long> {

}