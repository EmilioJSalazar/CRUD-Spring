package com.crud.dto;

import java.util.Date;

public class VotacionDTO {

	private Integer id;
	private Integer idUsuario;
	private Integer usuarioVotado;
	private Date fecha;
	
	public VotacionDTO(Integer id, Integer idUsuario, Integer usuarioVotado, Date fecha) {
		super();
		this.id = id;
		this.idUsuario = idUsuario;
		this.usuarioVotado = usuarioVotado;
		this.fecha = fecha;
	}
	
	public VotacionDTO(Integer idUsuario, Integer usuarioVotado, Date fecha) {
		super();
		this.idUsuario = idUsuario;
		this.usuarioVotado = usuarioVotado;
		this.fecha = fecha;
	}

	public VotacionDTO() {
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
	
	
	
}
