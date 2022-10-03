package com.crud.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;

@Controller
@RequestMapping("/usuarios") // http:localhost:8080/usuarios
public class UsuarioController {

	private final Logger logg = LoggerFactory.getLogger(Usuario.class);

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping("")
	public String home(Model model) {
		model.addAttribute("usuarios", usuarioRepository.findAll());
		return "home";
	}

	@GetMapping("/create") // http:localhost:8080/usuarios/create
	public String create() {
		return "create";
	}

	@PostMapping("/save")
	public String save(Usuario usuario) {
		logg.info("Información del objeto usuario, {}", usuario);
		usuarioRepository.save(usuario);
		return "redirect:/usuarios";
	}
	
	@GetMapping("/edit/{id}")
	public String edit(@PathVariable Integer id, Model model) {
		Usuario u = usuarioRepository.getOne(id);
		logg.info("Objeto recuperado {}",u);
		model.addAttribute("usuario", u);		
		return "edit";
	}
	
	@GetMapping("/delete/{id}")
	public String delete(@PathVariable Integer id) {
		Usuario u = usuarioRepository.getOne(id);
		logg.info("Objeto eliminado {}",u);	
		usuarioRepository.delete(u);
		return "redirect:/usuarios";
	}
}
