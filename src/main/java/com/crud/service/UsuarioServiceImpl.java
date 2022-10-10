package com.crud.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.UsuarioRegistroDTO;
import com.crud.model.Rol;
import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private UsuarioRepository usuarioRepository;

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO) {
		Usuario usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getCorreo(),
				registroDTO.getTelefono(), registroDTO.getContrasenia(), Arrays.asList(new Rol("ROLE_USER")));
		return usuarioRepository.save(usuario);
	}

}
