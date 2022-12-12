package com.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.dto.RangoRegistroDTO;
import com.crud.model.Rango;
import com.crud.repository.RangoRepository;
import com.crud.service.RangoService;

@Controller
@RequestMapping("/admin/tiempos")
public class RangoTiempoController {

	@Autowired
	private RangoService rangoService;
	

	@ModelAttribute("rango")
	public RangoRegistroDTO retornarNuevoRangoRegistroDTO() {
		return new RangoRegistroDTO();
	}
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("rangos", rangoService.listarRangos());
		return "tiempos";
	}
	
	
	@PostMapping
	public String registrarRangoTiempo(@ModelAttribute("rango") RangoRegistroDTO registroDTO) {
		rangoService.guardar(registroDTO, 0);
		return "redirect:/admin/tiempos?exito";
	}
	
	
}
