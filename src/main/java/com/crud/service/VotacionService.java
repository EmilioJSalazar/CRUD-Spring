package com.crud.service;

import java.util.List;

import com.crud.dto.VotacionDTO;
import com.crud.model.Votacion;

public interface VotacionService {
	
	public Votacion guardar(VotacionDTO VotacionDTO, Integer id);
	
	public List<Votacion> listarVotaciones();

}
