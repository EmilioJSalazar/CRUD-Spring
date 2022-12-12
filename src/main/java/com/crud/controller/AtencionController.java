package com.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.crud.dto.AtencionDTO;
import com.crud.model.Venta;
import com.crud.service.AtencionService;
import com.crud.service.RangoService;
import com.crud.service.VentaService;

@Controller
@RequestMapping("/atenciones")
public class AtencionController {

	@Autowired
	private AtencionService atencionService;
	
	@Autowired
	private RangoService rangoService;
		
	@Autowired
	private VentaService ventaService;
	

	@ModelAttribute("atencion")
	public AtencionDTO retornarNuevaAtencionDTO() {
		return new AtencionDTO();
	}
	
	@GetMapping
	public String listar(Model model) {
		model.addAttribute("rangos", rangoService.listarRangos());
		return "core/atenciones";
	}
	
	
	@PostMapping
	public String registrarAtencion(@ModelAttribute("atencion") AtencionDTO atencionDTO) {
		List<Venta> ventas = ventaService.listarVentas();
		int lastIdx = ventas.size() - 1;
		Venta lastElement = ventas.get(lastIdx);
		atencionDTO.setIdVenta(lastElement.getId());
		atencionService.guardar(atencionDTO, 0);
		return "redirect:/";
	}
	
	
}
