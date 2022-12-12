package com.crud.model;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "venta")
public class Venta {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "id_usuario", referencedColumnName = "id",insertable=false,updatable=false)
    @ManyToOne
    private Usuario usuario;
	
	@NotNull
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@NotNull
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "fecha")
	private Date fecha;

	@NotNull
	@Column(name = "num_factura")
	private String numFactura;
	
	@NotNull
	@Column(name = "subtotal")
	private Float subtotal;
	
	@NotNull
	@Column(name = "iva")
	private Float iva;
	
	@NotNull
	@Column(name = "total")
	private Float total;
	

	public Venta(Integer id, Usuario usuario, @NotNull Integer idUsuario, @NotNull Date fecha,
			@NotNull String numFactura, @NotNull Float subtotal, @NotNull Float iva, @NotNull Float total) {
		super();
		this.id = id;
		this.usuario = usuario;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.numFactura = numFactura;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	public Venta(Integer id, @NotNull Integer idUsuario, @NotNull Date fecha, @NotNull String numFactura,
			@NotNull Float subtotal, @NotNull Float iva, @NotNull Float total) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.numFactura = numFactura;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}
	
	public Venta(@NotNull Integer idUsuario, @NotNull Date fecha, @NotNull String numFactura,
			@NotNull Float subtotal, @NotNull Float iva, @NotNull Float total) {
		super();
		this.idUsuario = idUsuario;
		this.fecha = fecha;
		this.numFactura = numFactura;
		this.subtotal = subtotal;
		this.iva = iva;
		this.total = total;
	}

	public Venta() {
		super();
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

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

		
}
