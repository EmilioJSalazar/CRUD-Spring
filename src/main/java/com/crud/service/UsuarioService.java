package com.crud.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.crud.dto.UsuarioRegistroDTO;
import com.crud.model.Usuario;

public interface UsuarioService extends UserDetailsService{ //Hereda para la búsqueda de un usuario

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
}
