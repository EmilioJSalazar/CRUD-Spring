package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Atencion;

@Repository
public interface AtencionRepository extends JpaRepository<Atencion, Integer>{

	public Atencion findByidVenta(String idVenta);
}
