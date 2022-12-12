package com.crud.controller;

import java.text.ParseException;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.dto.VentaDTO;
import com.crud.model.Usuario;
import com.crud.repository.UsuarioRepository;
import com.crud.service.AtencionService;
import com.crud.service.VentaService;

@Controller
@RequestMapping("/ventas")
public class VentaController {

	private final Logger logg = LoggerFactory.getLogger(VentaDTO.class);

	@Autowired
	private VentaService ventaService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private AtencionService atencionService;
	
	

	@ModelAttribute("venta")
	public VentaDTO retornarNuevaVentaRegistroDTO() {
		return new VentaDTO();
	}
	
	@GetMapping
	public String inicio() {
		return "core/ventas";
	}
	
	@RequestMapping(value="/{username}", method=RequestMethod.POST)
	public String registrarVenta(@ModelAttribute("venta") VentaDTO ventaDTO, @PathVariable String username){
		Usuario user = usuarioRepository.findBycorreo(username);
		ventaDTO.setIdUsuario(user.getId());
		ventaService.guardar(ventaDTO, 0);
		logg.info("Info id {}", ventaDTO);
		return "redirect:/atenciones";
	}
	
	@GetMapping("/lista")
	public String crud(Model model) {
		model.addAttribute("atenciones", atencionService.listarAtenciones());
		return "core/listaventas";
	}
	
	
}
