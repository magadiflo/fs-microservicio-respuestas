package com.magadiflo.respuestas.app.models.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.magadiflo.commons.alumnos.models.entity.Alumno;
import com.magadiflo.commons.examenes.models.entity.Pregunta;

@Entity
@Table(name = "respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String texto;

	@Column(name = "alumno_id")
	private Long alumnoId;

	// @ManyToOne(fetch = FetchType.LAZY)
	@Transient // No será mapeado a la tabla de la BD
	private Alumno alumno;

	@OneToOne(fetch = FetchType.LAZY)
	private Pregunta pregunta;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
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
