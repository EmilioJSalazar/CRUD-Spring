package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.RangoRegistroDTO;
import com.crud.model.Rango;
import com.crud.repository.RangoRepository;

@Service
public class RangoServiceImpl implements RangoService{

	@Autowired
	private RangoRepository rangoRepository;
	
	@Override
	public Rango guardar(RangoRegistroDTO registroDTO, Integer id) {
		Rango rangoTiempo; 
		if(id==0) {
			rangoTiempo = new Rango(registroDTO.getRangoAtencion(), registroDTO.getDescripcion());
		}else {
			rangoTiempo = new Rango(id, registroDTO.getRangoAtencion(), registroDTO.getDescripcion());
		}
		
		return rangoRepository.save(rangoTiempo);
	}
	
	@Override
	public List<Rango> listarRangos() {
		return rangoRepository.findAll();
		
	}
}
