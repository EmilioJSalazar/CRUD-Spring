package com.crud.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;



@Entity
@Table(name = "usuarios", uniqueConstraints = @UniqueConstraint(columnNames = "correo"))
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@NotNull
	@Column(name = "nombre")
	private String nombre;

	@NotNull
	@Column(name = "apellido")
	private String apellido;

	@NotNull
	@Email
	@Column(name = "correo")
	private String correo;

	@NotNull
	@Column(name = "telefono")
	private String telefono;

	@NotNull
	@Column(name = "contrasenia")
	private String contrasenia;

	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	@JoinTable(name = "usuarios_roles",
		joinColumns = @JoinColumn(name = "usuario_id", referencedColumnName = "id"), 
		inverseJoinColumns = @JoinColumn(name = "rol_id", referencedColumnName = "id"))
	private Collection<Rol> roles;

	public Usuario() {
		super();
	}

	public Usuario(Integer id, String nombre, String apellido, String correo, String telefono, String contrasenia,
			Collection<Rol> roles) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
		this.roles = roles;
	}

	public Usuario(String nombre, String apellido, String correo, String telefono, String contrasenia,
			Collection<Rol> roles) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.correo = correo;
		this.telefono = telefono;
		this.contrasenia = contrasenia;
		this.roles = roles;
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

	public Collection<Rol> getRoles() {
		return roles;
	}

	public void setRoles(Collection<Rol> roles) {
		this.roles = roles;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", correo=" + correo
				+ ", telefono=" + telefono + ", contrasenia=" + contrasenia + "]";
	}

}
