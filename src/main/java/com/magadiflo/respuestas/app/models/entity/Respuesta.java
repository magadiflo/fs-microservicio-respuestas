package com.magadiflo.respuestas.app.models.entity;

import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import com.magadiflo.commons.alumnos.models.entity.Alumno;
import com.magadiflo.commons.examenes.models.entity.Pregunta;

// collection es como si fueran nuestras Tablas en una BD relacional
@Document(collection = "respuestas")
public class Respuesta {

	@Id
	private String id;

	private String texto;

	private Long alumnoId;

	private Long preguntaId;

	//@Transient
	private Alumno alumno;

	//@Transient
	private Pregunta pregunta;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTexto() {
		return texto;
	}

	public void setTexto(String texto) {
		this.texto = texto;
	}

	public Alumno getAlumno() {
		return alumno;
	}

	public void setAlumno(Alumno alumno) {
		this.alumno = alumno;
	}

	public Pregunta getPregunta() {
		return pregunta;
	}

	public void setPregunta(Pregunta pregunta) {
		this.pregunta = pregunta;
	}

	public Long getAlumnoId() {
		return alumnoId;
	}

	public void setAlumnoId(Long alumnoId) {
		this.alumnoId = alumnoId;
	}

	public Long getPreguntaId() {
		return preguntaId;
	}

	public void setPreguntaId(Long preguntaId) {
		this.preguntaId = preguntaId;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Respuesta [id=");
		builder.append(id);
		builder.append(", texto=");
		builder.append(texto);
		builder.append(", alumnoId=");
		builder.append(alumnoId);
		builder.append("]");
		return builder.toString();
	}

}
