package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.AtencionDTO;
import com.crud.model.Atencion;
import com.crud.repository.AtencionRepository;

@Service
public class AtencionServiceImpl implements AtencionService{

	@Autowired
	private AtencionRepository atencionRepository;
	
	@Override
	public Atencion guardar(AtencionDTO atencionDTO, Integer id) {
		Atencion atencion; 
		if(id==0) {
			atencion = new Atencion(atencionDTO.getIdVenta(), atencionDTO.getTiempoAtencion(), atencionDTO.getIdRango());
		}else {
			atencion = new Atencion(id, atencionDTO.getIdVenta(), atencionDTO.getTiempoAtencion(), atencionDTO.getIdRango());
		}
		
		return atencionRepository.save(atencion);
	}
	
	@Override
	public List<Atencion> listarAtenciones() {
		return atencionRepository.findAll();
		
	}

}
