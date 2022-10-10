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
@RequestMapping("/registro")
public class RegistroUsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;

	@ModelAttribute("usuario")
	public UsuarioRegistroDTO retornarNuevoUsuarioRgistroDTO() {
		return new UsuarioRegistroDTO();
	}
	
	@GetMapping
	public String mostrarFormularioDeRegistro() {
		return "registro";
	}
	
	@PostMapping
	public String registrarCuentaDeUsuario(@ModelAttribute("usuario") UsuarioRegistroDTO registroDTO) {
		usuarioService.guardar(registroDTO, 0);
		return "redirect:/registro?exito";
	}
}
