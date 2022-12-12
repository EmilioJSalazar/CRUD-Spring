package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.VentaDTO;
import com.crud.model.Venta;
import com.crud.repository.VentaRepository;

@Service
public class VentaServiceImpl implements VentaService {

	@Autowired
	private VentaRepository VentaRepository;

	@Override
	public Venta guardar(VentaDTO VentaDTO, Integer id) {
		Venta venta;
		if (id == 0) {
			venta = new Venta(VentaDTO.getIdUsuario(), VentaDTO.getFecha(), VentaDTO.getNumFactura(),
					VentaDTO.getSubtotal(),  VentaDTO.getIva(),  VentaDTO.getTotal());
		} else {
			venta = new Venta(id, VentaDTO.getIdUsuario(), VentaDTO.getFecha(), VentaDTO.getNumFactura(),
					VentaDTO.getSubtotal(),  VentaDTO.getIva(),  VentaDTO.getTotal());
		}

		return VentaRepository.save(venta);
	}

	@Override
	public List<Venta> listarVentas() {
		return VentaRepository.findAll();

	}

}
