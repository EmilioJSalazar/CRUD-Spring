package com.crud.service;

import java.text.SimpleDateFormat;
import java.sql.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.dto.VotacionDTO;
import com.crud.model.Votacion;
import com.crud.repository.VotacionRepository;

@Service
public class VotacionServiceImpl implements VotacionService {

	@Autowired
	private VotacionRepository VotacionRepository;

	@Override
	public Votacion guardar(VotacionDTO votacionDTO, Integer id) {
		Votacion votacion;
		if (id == 0) {
			votacion = new Votacion(votacionDTO.getIdUsuario(), votacionDTO.getUsuarioVotado(), votacionDTO.getFecha());
		} else {
			votacion = new Votacion(id, votacionDTO.getIdUsuario(), votacionDTO.getUsuarioVotado(), votacionDTO.getFecha());
		}

		return VotacionRepository.save(votacion);
	}

	@Override
	public List<Votacion> listarVotaciones() {
		return VotacionRepository.findAll();

	}

}
