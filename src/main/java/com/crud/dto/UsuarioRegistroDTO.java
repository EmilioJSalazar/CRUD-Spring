package com.crud.dto;

public class UsuarioRegistroDTO {

	private Integer id;
	private String nombre;
	private String apellido;
	private String correo;
	private String telefono;
	private String contrasenia;

	public UsuarioRegistroDTO() {
		super();
	}

	public UsuarioRegistroDTO(Integer id, String nombre, String apellido, String correo, String telefono,
			String contrasenia) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
	}

	public UsuarioRegistroDTO(String nombre, String apellido, String correo, String telefono, String contrasenia) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
	}

	public UsuarioRegistroDTO(String correo) {
		super();
		this.correo = correo;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getContrasenia() {
		return contrasenia;
	}

	public void setContrasenia(String contrasenia) {
		this.contrasenia = contrasenia;
	}

}
