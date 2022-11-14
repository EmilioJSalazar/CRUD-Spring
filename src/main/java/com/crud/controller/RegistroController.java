package com.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegistroController {

	@GetMapping("/login")
	public String iniciarSesion() {
		return "login";
	}
	
	
	@GetMapping("/")
	public String verPaginaDeInicio() {
		return "index";
	}
	
	@GetMapping("/admin")
	public String administrador() {
		return "admin";
	}
	
}
