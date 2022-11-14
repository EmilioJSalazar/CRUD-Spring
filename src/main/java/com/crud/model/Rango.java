package com.crud.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "rango_tiempo")
public class Rango {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "rango_atencion")
	private String rangoAtencion;
	
	@NotNull
	@Column(name = "descripcion")
	private String descripcion;

	public Rango() {
		super();
	}

	public Rango(Integer id, @NotNull String rangoAtencion, @NotNull String descripcion) {
		super();
		this.id = id;
		this.rangoAtencion = rangoAtencion;
		this.descripcion = descripcion;
	}
	
	
	public Rango(@NotNull String rangoAtencion, @NotNull String descripcion) {
		super();
		this.rangoAtencion = rangoAtencion;
		this.descripcion = descripcion;
	}

	public Rango(String rango_atencion) {
		super();
		this.rangoAtencion = rango_atencion;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getRangoAtencion() {
		return rangoAtencion;
	}

	public void setRangoAtencion(String rangoAtencion) {
		this.rangoAtencion = rangoAtencion;
	}

	public String getDescripcion() {
		return descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	@Override
	public String toString() {
		return rangoAtencion + " (" + descripcion + ")";
	}
	
	
}
