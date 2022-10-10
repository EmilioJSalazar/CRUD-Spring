package com.crud.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.crud.dto.UsuarioRegistroDTO;
import com.crud.model.Rol;
import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;

	private UsuarioRepository usuarioRepository;

	public UsuarioServiceImpl(UsuarioRepository usuarioRepository) {
		super();
		this.usuarioRepository = usuarioRepository;
	}

	@Override
	public Usuario guardar(UsuarioRegistroDTO registroDTO, Integer id) {
		Usuario usuario; 
		if(id==0) {
			usuario = new Usuario(registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getCorreo(),
				registroDTO.getTelefono(), passwordEncoder.encode(registroDTO.getContrasenia()), Arrays.asList(new Rol("ROLE_USER")));
		}else {
			usuario = new Usuario(id, registroDTO.getNombre(), registroDTO.getApellido(), registroDTO.getCorreo(),
					registroDTO.getTelefono(), passwordEncoder.encode(registroDTO.getContrasenia()), Arrays.asList(new Rol("ROLE_USER")));
		}
		
		return usuarioRepository.save(usuario);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Usuario usuario = usuarioRepository.findBycorreo(username);
		if(usuario == null) {
			throw new UsernameNotFoundException("Usuario o password inválidos");
		}
		return new User(usuario.getCorreo(), usuario.getContrasenia(), mapearAutoridadesARoles(usuario.getRoles()));
	}
	
		//Mapea a los roles
	private Collection<? extends GrantedAuthority> mapearAutoridadesARoles(Collection<Rol> roles) {
		return roles.stream().map(role -> new SimpleGrantedAuthority(role.getNombre())).collect(Collectors.toList());
	}

	@Override
	public List<Usuario> listarUsuarios() {
		return usuarioRepository.findAll();
	}


}
