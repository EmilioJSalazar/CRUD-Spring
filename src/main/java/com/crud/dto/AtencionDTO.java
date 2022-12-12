package com.crud.dto;

public class AtencionDTO {

	private Integer id;
	private Integer idVenta;
	private Integer tiempoAtencion;
	private Integer idRango;
	
	
	public AtencionDTO(Integer id, Integer idVenta, Integer tiempoAtencion, Integer idRango) {
		super();
		this.id = id;
		this.idVenta = idVenta;
		this.tiempoAtencion = tiempoAtencion;
		this.idRango = idRango;
	}
	
	public AtencionDTO(Integer idVenta, Integer tiempoAtencion, Integer idRango) {
		super();
		this.idVenta = idVenta;
		this.tiempoAtencion = tiempoAtencion;
		this.idRango = idRango;
	}

	public AtencionDTO() {
		super();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdVenta() {
		return idVenta;
	}

	public void setIdVenta(Integer idVenta) {
		this.idVenta = idVenta;
	}

	public Integer getTiempoAtencion() {
		return tiempoAtencion;
	}

	public void setTiempoAtencion(Integer tiempoAtencion) {
		this.tiempoAtencion = tiempoAtencion;
	}

	public Integer getIdRango() {
		return idRango;
	}

	public void setIdRango(Integer idRango) {
		this.idRango = idRango;
	}	
	
	
}
