package com.crud.controller;

import java.sql.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.crud.dto.VotacionDTO;
import com.crud.model.Atencion;
import com.crud.model.Usuario;
import com.crud.model.Votacion;
import com.crud.repository.UsuarioRepository;
import com.crud.service.AtencionService;
import com.crud.service.UsuarioService;
import com.crud.service.VotacionService;

@Controller
@RequestMapping("/reporte")
public class ReporteController {

	@Autowired
	private VotacionService votacionService;

	@Autowired
	private UsuarioService usuarioService;

	@Autowired
	private AtencionService atencionService;

	@Autowired
	private UsuarioRepository usuarioRepository;

	@GetMapping
	public String listar(Model model) {
		return "core/reporte";
	}

	@GetMapping("/listar")
	public String listarReporte(Model model, List<List<String>> result, List<List<String>> info) {
		model.addAttribute("usuarios", result);
		model.addAttribute("infoSeleccionada", info);
		return "core/reporte";
	}

	@RequestMapping(value = "/resultado", method = { RequestMethod.POST, RequestMethod.GET })
	public String registrarVotacion(Model model, Date fecha, String option) {

		List<List<String>> resultados = new ArrayList<>();

		System.out.println("Fecha: " + fecha);
		System.out.println("Option: " + option);
		List<String> infor = new ArrayList<String>();
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		System.out.println(dateFormat.format(fecha));
		infor.add(dateFormat.format(fecha));
		infor.add(option);
		List<List<String>> info = new ArrayList<>();
		info.add(infor);

		for (Usuario temp : usuarioService.listarUsuarios()) {
			List<String> users = new ArrayList<String>();
			users.add(Integer.toString(temp.getId()));
			users.add(temp.getNombre());
			users.add(temp.getApellido());
			users.add(temp.getCorreo());
			int i = 0;
			int tiempoAtencion = 0;
			int DiaSeleccionado = fecha.getDate();
			for (Atencion ate : atencionService.listarAtenciones()) {
				int DiaVenta = ate.getVenta().getFecha().getDate();
				if (ate.getVenta().getIdUsuario() == temp.getId() && DiaSeleccionado == DiaVenta) {
					i++;
					tiempoAtencion = tiempoAtencion + ate.getTiempoAtencion();
					System.out.println("DS: " + DiaSeleccionado);
					System.out.println("DV: " + DiaSeleccionado);
					System.out.println(ate.getIdVenta());
				}
			}
			float promedio;
			if (i != 0) {
				promedio = tiempoAtencion / i;
			} else {
				promedio = 0;
			}

			users.add(Integer.toString(i));
			users.add(Float.toString(promedio));

			int votos = 0;
			int MesSeleccionado = fecha.getMonth();
			for (Votacion vot : votacionService.listarVotaciones()) {
				if (vot.getUsuarioVotado() == temp.getId() && MesSeleccionado == vot.getFecha().getMonth()) {
					votos++;
				}
			}
			users.add(Integer.toString(votos));

			resultados.add(users);
		}

		switch (option) {
		case "ventas":
			Collections.sort(resultados, new Comparator<List<String>>(){
				public int compare(List<String> r1, List<String> r2) {
					int temp1 = Integer.parseInt(r1.get(4));
					int temp2 = Integer.parseInt(r2.get(4));
					return new Integer(temp2).compareTo(new Integer(temp1));
				}
			});
			return listarReporte(model, resultados, info);

		case "atencion":
			Collections.sort(resultados, new Comparator<List<String>>(){
				public int compare(List<String> r1, List<String> r2) {
					float temp1 = Float.parseFloat(r1.get(5));
					float temp2 = Float.parseFloat(r2.get(5));
					return new Float(temp2).compareTo(new Float(temp1));
				}
			});
			return listarReporte(model, resultados, info);

		case "votacion":
			Collections.sort(resultados, new Comparator<List<String>>(){
				public int compare(List<String> r1, List<String> r2) {
					int temp1 = Integer.parseInt(r1.get(6));
					int temp2 = Integer.parseInt(r2.get(6));
					return new Integer(temp2).compareTo(new Integer(temp1));
				}
			});
			return listarReporte(model, resultados, info);
		}
		return "redirect:/reporte";
	}

}
