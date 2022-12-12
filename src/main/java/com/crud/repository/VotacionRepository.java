package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Votacion;

@Repository
public interface VotacionRepository extends JpaRepository<Votacion, Integer>{

	public Votacion findByid(Integer id);
}
