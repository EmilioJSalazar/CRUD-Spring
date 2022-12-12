package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.model.Venta;

@Repository
public interface VentaRepository extends JpaRepository<Venta, Integer>{

	public Venta findBynumFactura(String numFactura);
}
