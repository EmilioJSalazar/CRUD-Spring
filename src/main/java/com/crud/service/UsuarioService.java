package com.crud.service;

import com.crud.dto.UsuarioRegistroDTO;
import com.crud.model.Usuario;

public interface UsuarioService {

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
}
