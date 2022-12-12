package com.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.dto.AtencionDTO;
import com.crud.dto.UsuarioRegistroDTO;
import com.crud.dto.VentaDTO;
import com.crud.dto.VotacionDTO;
import com.crud.model.Usuario;
import com.crud.model.Venta;
import com.crud.repository.UsuarioRepository;
import com.crud.service.AtencionService;
import com.crud.service.RangoService;
import com.crud.service.UsuarioService;
import com.crud.service.VentaService;
import com.crud.service.VotacionService;

@Controller
@RequestMapping("/votaciones")
public class VotacionController {

	@Autowired
	private VotacionService votacionService;
	
	@Autowired
	private UsuarioService usuarioService;
	
	@Autowired
	private UsuarioRepository usuarioRepository;
		
	@Autowired
	private VentaService ventaService;
	

	@ModelAttribute("votacion")
	public VotacionDTO retornarNuevaVotacionDTO() {
		return new VotacionDTO();
	}
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("usuarios", usuarioService.listarUsuarios());
		return "core/votaciones";
	}
	
	@GetMapping("/{username}")
	public String inicio(Model model, @PathVariable String username) {
		Usuario u = usuarioRepository.findBycorreo(username);
		
		List<Usuario> users = new ArrayList<>();;
		
		for(Usuario temp : usuarioService.listarUsuarios()) {
			if(temp != u) {
				users.add(temp);
			}
		}

		model.addAttribute("usuarios", users);
		return "core/votaciones";
	}
	
	@RequestMapping(value="/{username}/{id}", method=RequestMethod.GET)
	public String registrarVotacion(@ModelAttribute("atencion") VotacionDTO votacionDTO, @PathVariable String username, @PathVariable Integer id) {
		Usuario user1 = usuarioRepository.findBycorreo(username);
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		votacionDTO.setIdUsuario(user1.getId());
		votacionDTO.setUsuarioVotado(id);
		votacionDTO.setFecha(sqlDate);
		votacionService.guardar(votacionDTO, 0);
		return "redirect:/votaciones?exito";
	}
	
	
}
