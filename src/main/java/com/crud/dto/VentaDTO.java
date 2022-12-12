package com.crud.dto;

import java.sql.Date;

public class VentaDTO {

	private Integer id;
	private Integer idUsuario;
	private Date fecha;
	private String numFactura;
	private Float subtotal;
	private Float iva;
	private Float total;
	
	public VentaDTO() {
		super();
	}

	public VentaDTO(Integer id, Integer idUsuario, Date fecha, String numFactura, Float subtotal, Float iva,
			Float total) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.numFactura = numFactura;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}
	
	public VentaDTO(Integer idUsuario, Date fecha, String numFactura, Float subtotal, Float iva,
			Float total) {
		super();
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.numFactura = numFactura;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
		this.idUsuario = idUsuario;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	public String getNumFactura() {
		return numFactura;
	}

	public void setNumFactura(String numFactura) {
		this.numFactura = numFactura;
	}

	public Float getSubtotal() {
		return subtotal;
	}

	public void setSubtotal(Float subtotal) {
		this.subtotal = subtotal;
	}

	public Float getIva() {
		return iva;
	}

	public void setIva(Float iva) {
		this.iva = iva;
	}

	public Float getTotal() {
		return total;
	}

	public void setTotal(Float total) {
		this.total = total;
	}
			
	
}
