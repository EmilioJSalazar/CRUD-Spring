package com.crud.dto;


public class RangoRegistroDTO {

	private Integer id;
	private String rangoAtencion;
	private String descripcion;
	
	
	public RangoRegistroDTO() {
		super();
	}

	public RangoRegistroDTO(String rangoAtencion, String descripcion) {
		super();
		this.rangoAtencion = rangoAtencion;
		this.descripcion = descripcion;
	}

	public RangoRegistroDTO(String rangoAtencion) {
		super();
		this.rangoAtencion = rangoAtencion;
	}

	public RangoRegistroDTO(Integer id, String rangoAtencion, String descripcion) {
		super();
		this.id = id;
		this.rangoAtencion = rangoAtencion;
		this.descripcion = descripcion;
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
	
	
}
