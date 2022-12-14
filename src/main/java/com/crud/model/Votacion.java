package com.crud.model;



import java.sql.Date;

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
@Table(name = "votacion")
public class Votacion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@JoinColumn(name = "id_usuario", referencedColumnName = "id",insertable=false,updatable=false)
    @ManyToOne
    private Usuario usuario1;
	
	@NotNull
	@Column(name = "id_usuario")
	private Integer idUsuario;
	
	@JoinColumn(name = "usuario_votado", referencedColumnName = "id",insertable=false,updatable=false)
    @ManyToOne
    private Usuario usuario2;
	
	@NotNull
	@Column(name = "usuario_votado")
	private Integer usuarioVotado;
	
	@NotNull
	@Column(name = "fecha")
	private Date fecha;
	
	

	public Votacion(Integer id, Usuario usuario1, @NotNull Integer idUsuario, Usuario usuario2,
			@NotNull Integer usuarioVotado, @NotNull Date fecha) {
		super();
		this.id = id;
		this.usuario1 = usuario1;
		this.idUsuario = idUsuario;
		this.usuario2 = usuario2;
		this.usuarioVotado = usuarioVotado;
		this.fecha = fecha;
	}

	public Votacion(Integer id, @NotNull Integer idUsuario, @NotNull Integer usuarioVotado, @NotNull Date fecha) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.usuarioVotado = usuarioVotado;
		this.fecha = fecha;
	}
	
	public Votacion(@NotNull Integer idUsuario, @NotNull Integer usuarioVotado, @NotNull Date date) {
		super();
		this.idUsuario = idUsuario;
		this.usuarioVotado = usuarioVotado;
		this.fecha = date;
	}
	

	public Votacion(@NotNull Date fecha) {
		super();
		this.fecha = fecha;
	}

	public Votacion() {
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

	public Integer getUsuarioVotado() {
		return usuarioVotado;
	}

	public void setUsuarioVotado(Integer usuarioVotado) {
		this.usuarioVotado = usuarioVotado;
	}

	public Date getFecha() {
		return fecha;
	}

	public void setFecha(Date fecha) {
		this.fecha = fecha;
	}

	@Override
	public String toString() {
		return "Votacion [id=" + id + ", usuario1=" + usuario1 + ", idUsuario=" + idUsuario + ", usuario2=" + usuario2
				+ ", usuarioVotado=" + usuarioVotado + ", fecha=" + fecha + "]";
	}

	
	
	
}
