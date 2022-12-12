package com.crud.service;

import java.util.List;

import com.crud.dto.VentaDTO;
import com.crud.model.Venta;

public interface VentaService {
	
	public Venta guardar(VentaDTO VentaDTO, Integer id);
	
	public List<Venta> listarVentas();

}
