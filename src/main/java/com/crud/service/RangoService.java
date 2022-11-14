package com.crud.service;

import java.util.List;

import com.crud.dto.RangoRegistroDTO;
import com.crud.model.Rango;

public interface RangoService {
	
	public Rango guardar(RangoRegistroDTO registroDTO, Integer id);
	
	public List<Rango> listarRangos();

}
