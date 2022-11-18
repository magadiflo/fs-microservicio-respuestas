package com.magadiflo.respuestas.app.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.magadiflo.commons.examenes.models.entity.Examen;
import com.magadiflo.commons.examenes.models.entity.Pregunta;
import com.magadiflo.respuestas.app.clients.IExamenFeignClient;
import com.magadiflo.respuestas.app.models.entity.Respuesta;
import com.magadiflo.respuestas.app.models.repository.IRespuestaRepository;

@Service
public class RespuestaServiceImpl implements IRespuestaService {

	private final IRespuestaRepository respuestaRepository;
	private final IExamenFeignClient examenFeignClient;

	public RespuestaServiceImpl(IRespuestaRepository respuestaRepository, IExamenFeignClient examenFeignClient) {
		this.respuestaRepository = respuestaRepository;
		this.examenFeignClient = examenFeignClient;
	}

	@Override
	public Iterable<Respuesta> saveAll(Iterable<Respuesta> respuestas) {
		return this.respuestaRepository.saveAll(respuestas);
	}

	@Override
	public Iterable<Respuesta> findRespuestasByAlumnoByExamen(Long alumnoId, Long examenId) {
		Examen examen = this.examenFeignClient.obtenerExamenPorId(examenId);
		List<Pregunta> preguntas = examen.getPreguntas();
		List<Long> preguntasIds = preguntas.stream().map(p -> p.getId()).collect(Collectors.toList());
		List<Respuesta> respuestas = (List<Respuesta>) this.respuestaRepository
				.findRespuestasByAlumnoByPreguntaIds(alumnoId, preguntasIds);

		respuestas = respuestas.stream().map(r -> {
			preguntas.forEach(p -> {
				if (p.getId() == r.getPreguntaId()) {
					r.setPregunta(p);
				}
			});
			return r;
		}).collect(Collectors.toList());

		return respuestas;
	}

	@Override
	public Iterable<Long> findExamenesIdsConRespuestasPorAlumno(Long alumnoId) {
		return null;
	}

}
