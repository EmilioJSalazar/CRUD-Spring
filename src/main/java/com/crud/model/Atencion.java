package com.crud.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "atencion")
public class Atencion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "id_venta", referencedColumnName = "id",insertable=false,updatable=false)
    @OneToOne
    private Venta venta;
	
	@NotNull
	@Column(name = "id_venta")
	private Integer idVenta;
	
	@NotNull
	@Column(name = "tiempo_atencion")
	private Integer tiempoAtencion;
	
	@JoinColumn(name = "id_rango", referencedColumnName = "id",insertable=false,updatable=false)
    @ManyToOne
    private Rango rango;
	
	@NotNull
	@Column(name = "id_rango")
	private Integer idRango;
	

	public Atencion(Integer id, Venta venta, @NotNull Integer idVenta, @NotNull Integer tiempoAtencion, Rango rango,
			@NotNull Integer idRango) {
		super();
		this.id = id;
		this.venta = venta;
		this.idVenta = idVenta;
		this.tiempoAtencion = tiempoAtencion;
		this.rango = rango;
		this.idRango = idRango;
	}

	public Atencion(Integer id, @NotNull Integer idVenta, @NotNull Integer tiempoAtencion, @NotNull Integer idRango) {
		super();
		this.id = id;
		this.idVenta = idVenta;
		this.tiempoAtencion = tiempoAtencion;
		this.idRango = idRango;
	}
	
	public Atencion(@NotNull Integer idVenta, @NotNull Integer tiempoAtencion, @NotNull Integer idRango) {
		super();
		this.idVenta = idVenta;
		this.tiempoAtencion = tiempoAtencion;
		this.idRango = idRango;
	}

	public Atencion() {
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

	public Venta getVenta() {
		return venta;
	}

	public void setVenta(Venta venta) {
		this.venta = venta;
	}

	public Rango getRango() {
		return rango;
	}

	public void setRango(Rango rango) {
		this.rango = rango;
	}
	
}
