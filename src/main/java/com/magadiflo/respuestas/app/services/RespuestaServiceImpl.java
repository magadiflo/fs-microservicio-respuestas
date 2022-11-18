package com.magadiflo.respuestas.app.services;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.magadiflo.respuestas.app.models.entity.Respuesta;
import com.magadiflo.respuestas.app.models.repository.IRespuestaRepository;

@Service
public class RespuestaServiceImpl implements IRespuestaService {

	private final IRespuestaRepository respuestaRepository;

	public RespuestaServiceImpl(IRespuestaRepository respuestaRepository) {
		this.respuestaRepository = respuestaRepository;
	}

	@Override
	@Transactional
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return this.respuestaRepository.saveAll(respuestas);
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId) {
		return null;
	}

	@Override
	@Transactional(readOnly = true)
	public Iterable<Long> findExamenesIdsConRespuestasPorAlumno(Long alumnoId) {
		return null;
	}

}
