package com.crud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.dto.VotacionDTO;
import com.crud.model.Usuario;
import com.crud.model.Votacion;
import com.crud.repository.UsuarioRepository;
import com.crud.repository.VotacionRepository;
import com.crud.service.UsuarioService;
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
	private VotacionRepository votacionRepository;

	@ModelAttribute("votacion")
	public VotacionDTO retornarNuevaVotacionDTO() {
		return new VotacionDTO();
	}

	@GetMapping
	public String listar(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		System.out.println(auth.getName());
		Usuario u = usuarioRepository.findBycorreo(auth.getName());

		List<Usuario> users = new ArrayList<>();

		for (Usuario temp : usuarioService.listarUsuarios()) {
			if (temp != u) {
				users.add(temp);
			}
		}
		
		model.addAttribute("usuarios", users);
		return "core/votaciones";
	}

	@RequestMapping(value = "/{username}/{id}", method = RequestMethod.GET)
	public String registrarVotacion(@ModelAttribute("votacion") VotacionDTO votacionDTO, @PathVariable String username,
			@PathVariable Integer id) {
		Usuario user1 = usuarioRepository.findBycorreo(username);
		java.util.Date date = new java.util.Date();
		java.sql.Date sqlDate = new java.sql.Date(date.getTime());
		votacionDTO.setIdUsuario(user1.getId());
		votacionDTO.setUsuarioVotado(id);
		votacionDTO.setFecha(sqlDate);
		
		Votacion lastVoto = new Votacion();
		Boolean flagDate = false;
		System.out.println(user1.getId());
		try {
			List<Votacion> votos = votacionRepository.findByIdUsuario(user1.getId());
			int lastIdx = votos.size() - 1;
			lastVoto = votos.get(lastIdx);
			
			System.out.println("VOTO INFO: " + lastVoto.toString());
			int mesActual = sqlDate.getMonth();
			int mesVoto = lastVoto.getFecha().getMonth();
			System.out.println("A: "+mesActual + "V: " + mesVoto);
			if(mesActual==mesVoto) {
				flagDate = false;
				System.out.println("false");
			}else {
				flagDate = true;
				System.out.println("true");
			}
		} catch (Exception e) {
			System.out.println("voto es null");
			flagDate = true;
		}
		
		if (flagDate) {
			votacionService.guardar(votacionDTO, 0);
			return "redirect:/votaciones?exito";
		} else {
			return "redirect:/votaciones?fracaso";
		}
	}

}
