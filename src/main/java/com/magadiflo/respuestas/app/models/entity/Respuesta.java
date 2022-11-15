package com.magadiflo.respuestas.app.models.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "respuestas")
public class Respuesta {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	private String texto;

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

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Respuesta [id=");
		builder.append(id);
		builder.append(", texto=");
		builder.append(texto);
		builder.append("]");
		return builder.toString();
	}

}
