package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.dto.UsuarioRegistroDTO;
import com.crud.service.UsuarioService;

@Controller
@RequestMapping("/create")
public class RegistroUsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRgistroDTO() {
		return new UsuarioRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "create";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		usuarioService.guardar(registroDTO);
		return "redirect:/create?exito";
	}
}
