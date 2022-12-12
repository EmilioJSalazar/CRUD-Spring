package com.crud.service;

import java.util.List;

import com.crud.dto.AtencionDTO;
import com.crud.model.Atencion;

public interface AtencionService {
	
	public Atencion guardar(AtencionDTO atencionDTO, Integer id);
	
	public List<Atencion> listarAtenciones();

}
