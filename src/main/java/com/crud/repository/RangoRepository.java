package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Rango;

@Repository
public interface RangoRepository extends JpaRepository<Rango, Integer>{

	public Rango findByrangoAtencion(String rangoAtencion);
}
